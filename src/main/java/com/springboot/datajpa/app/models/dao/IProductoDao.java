package com.springboot.datajpa.app.models.dao;

import com.springboot.datajpa.app.models.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {

  @Query("select p from Producto p where p.nombre like %?1%")
  List<Producto> findByNombre(String nombre);
}
