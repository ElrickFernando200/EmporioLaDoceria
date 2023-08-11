package com.develrick.emporioladoceria.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant instant;
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;
    public Pedido(){
    }

    public Pedido(Long id, Instant instant, StatusPedido status,Usuario cliente){
        this.id = id;
        this.instant = instant;
        this.status = status;
        this.cliente = cliente;
        this.instant = Instant.now();
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

    public StatusPedido getStatus(){
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Usuario getCliente(){
        return cliente;
    }

    public void setCliente(Usuario cliente){
        this.cliente = cliente;
    }

}
