package com.springboot.datajpa.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

  private static final long serialVersionUID = -1634218562371832296L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  private String descripcion;

  private String observacion;

  @Temporal(TemporalType.DATE)
  @Column(name = "created_at")
  private Date createdAt;

  @ManyToOne(fetch = FetchType.LAZY)
  private Cliente cliente;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "factura_id")
  private List<ItemFactura> items;

  public Factura() {
    this.items = new ArrayList<>();
  }

  @PrePersist
  public void prePersist() {
    this.createdAt = new Date();
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String obersvacion) {
    this.observacion = obersvacion;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<ItemFactura> getItems() {
    return items;
  }

  public void setItems(List<ItemFactura> items) {
    this.items = items;
  }

  public void addItemFactura(ItemFactura item) {
    this.items.add(item);
  }

  public Double getTotal() {
    Double total = 0.0;
    int size = items.size();

    for (int i = 0; i < size; i++) {
      total += items.get(i).calcularImporte();
    }
    return total;
  }
}
