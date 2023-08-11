package com.develrick.emporioladoceria.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant instant;
    private Double valor;

    @OneToOne
    @MapsId
    private Pedido pedido;

    public Pagamento(){}

    public Pagamento(Long id, Instant instant,Double valor,Pedido pedido){
        this.id = id;
        this.instant = instant;
        this.valor = valor;
        this.pedido = pedido;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Instant getInstant(){
        return instant;
    }

    public void setInstant(Instant instant){
        this.instant = instant;
    }

    public Double getValor(){
        return valor;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public Pedido getPedido(){
        return pedido;
    }

    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(getId(), pagamento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
