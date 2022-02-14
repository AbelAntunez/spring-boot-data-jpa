package com.springboot.datajpa.app.services.impl;

import com.springboot.datajpa.app.models.dao.IClienteDao;
import com.springboot.datajpa.app.models.dao.IProductoDao;
import com.springboot.datajpa.app.models.entity.Cliente;
import com.springboot.datajpa.app.models.entity.Producto;
import com.springboot.datajpa.app.services.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {

  @Autowired
  private IClienteDao clienteDao;

  @Autowired
  private IProductoDao productoDao;

  @Override
  @Transactional(readOnly = true)
  public List<Cliente> findAll() {
    return (List<Cliente>) clienteDao.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Page<Cliente> findAll(Pageable pageable) {
    return clienteDao.findAll(pageable);
  }

  @Override
  @Transactional
  public void save(Cliente cliente) {
    clienteDao.save(cliente);
  }

  @Override
  @Transactional(readOnly = true)
  public Cliente findById(Long id) {
    return clienteDao.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    clienteDao.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Producto> findByNombre(String nombre) {
    return productoDao.findByNombre(nombre);
  }
}
