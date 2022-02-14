package com.springboot.datajpa.app.models.dao;

import com.springboot.datajpa.app.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long> {

}
