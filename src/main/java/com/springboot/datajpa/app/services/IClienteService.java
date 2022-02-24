package com.springboot.datajpa.app.services;

import com.springboot.datajpa.app.models.entity.Cliente;
import com.springboot.datajpa.app.models.entity.Factura;
import com.springboot.datajpa.app.models.entity.Producto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClienteService {

  List<Cliente> findAll();

  Page<Cliente> findAll(Pageable pageable);

  void save(Cliente cliente);

  Cliente findById(Long id);

  void delete(Long id);

  List<Producto> findByNombre(String nombre);

  void saveFactura(Factura factura);

  Producto findProductoById(Long id);

  Factura findFacturaById(Long id);

  void deleteFactura(Long id);

  Factura fetchFacturaByIdWithClienteWithItemFacturaWithProducto(Long id);

  Cliente fetchByIdWithFacturas(Long id);
}
