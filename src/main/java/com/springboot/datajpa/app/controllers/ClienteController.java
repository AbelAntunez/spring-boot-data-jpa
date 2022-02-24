package com.springboot.datajpa.app.controllers;

import com.springboot.datajpa.app.models.entity.Cliente;
import com.springboot.datajpa.app.services.IClienteService;
import com.springboot.datajpa.app.services.IUploadFileService;
import com.springboot.datajpa.app.util.paginator.PageRender;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

  @Autowired
  private IClienteService clienteService;

  @Autowired
  private IUploadFileService uploadFileService;

  @GetMapping("/uploads/{filename:.+}")
  public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

    Resource resource = null;
    try {
      resource = uploadFileService.load(filename);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }

  @GetMapping("/ver/{id}")
  public String ver(@PathVariable Long id, Model model, RedirectAttributes flash) {

    Cliente cliente = clienteService.fetchByIdWithFacturas(id); //clienteService.findById(id);
    if (cliente == null) {
      flash.addFlashAttribute("error", "El cliente no existe en la BBDD");
      return "redirect:/listar";
    }
    model.addAttribute("titulo", "Detalle cliente: " + cliente.getNombre());
    model.addAttribute("cliente", cliente);

    return "ver";
  }

  @GetMapping({"/", "/listar"})
  public String listar(@RequestParam(defaultValue = "0") int page, Model model) {

    Pageable pageRequest = PageRequest.of(page, 5);
    Page<Cliente> clientes = clienteService.findAll(pageRequest);
    PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);

    model.addAttribute("titulo", "Listado de clientes");
    model.addAttribute("clientes", clientes);
    model.addAttribute("page", pageRender);
    // Sin paginación
    //model.addAttribute("clientes", clienteService.findAll());
    return "listar";
  }

  @GetMapping("/form")
  public String crear(Model model) {

    Cliente cliente = new Cliente();
    model.addAttribute("cliente", cliente);
    model.addAttribute("titulo", "Formulario de cliente");
    return "form";
  }

  @PostMapping("/form")
  public String guardar(@Valid Cliente cliente, BindingResult result, Model model,
      @RequestParam(name = "file") MultipartFile foto,
      RedirectAttributes flash,
      SessionStatus status) {

    if (result.hasErrors()) {
      model.addAttribute("titulo", "Formulario de cliente");
      return "form";
    }

    String mensajeFlash =
        cliente.getId() != null ? "Cliente editado con éxito!" : "Cliente creado con éxito!";

    if (!foto.isEmpty()) {

      if (cliente.getId() != null && cliente.getId() > 0
          && cliente.getFoto() != null
          && cliente.getFoto().length() > 0) {

        uploadFileService.delete(cliente.getFoto());
      }
      String uniqueFileName = null;
      try {
        uniqueFileName = uploadFileService.copy(foto);
      } catch (IOException e) {
        e.printStackTrace();
      }
      flash.addFlashAttribute("info",
          "Has subido correctamente '" + uniqueFileName + "'");
      cliente.setFoto(uniqueFileName);
    }

    clienteService.save(cliente);
    status.setComplete();
    flash.addFlashAttribute("success", mensajeFlash);
    return "redirect:listar";
  }

  @GetMapping("/form/{id}")
  public String editar(@PathVariable Long id, Model model, RedirectAttributes flash) {

    Cliente cliente = null;
    if (id > 0) {
      cliente = clienteService.findById(id);
      if (cliente == null) {
        flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
        return "redirect:/listar";
      }
    } else {
      flash.addFlashAttribute("error", "ID de cliente inválido!");
      return "redirect:/listar";
    }

    model.addAttribute("cliente", cliente);
    model.addAttribute("titulo", "Editar cliente");
    return "form";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Long id, Model model, RedirectAttributes flash) {

    Cliente cliente = null;
    if (id > 0) {
      cliente = clienteService.findById(id);
      if (cliente == null) {
        flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
        return "redirect:/listar";
      }
      clienteService.delete(id);
      flash.addFlashAttribute("success", "Cliente eliminado con éxito!");

      if (cliente.getFoto() != null && uploadFileService.delete(cliente.getFoto())) {
        flash.addFlashAttribute("info", "Foto " + cliente.getFoto() + " eliminada con éxito");
      }

    }

    return "redirect:/listar";
  }

}
