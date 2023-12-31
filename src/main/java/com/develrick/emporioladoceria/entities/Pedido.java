package com.develrick.emporioladoceria.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant instant;
    private StatusPedido status;

    @OneToOne(mappedBy = "pedido",cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;


    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itemPedidos = new HashSet<>();



    public Pedido(){
    }

    public Pedido(Long id, Instant instant, StatusPedido status,Usuario cliente,Pagamento pagamento){
        this.id = id;
        this.instant = instant;
        this.status = status;
        this.cliente = cliente;
        this.pagamento = pagamento;
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

    public Pagamento getPagamento(){
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento){
        this.pagamento = pagamento;
    }

    public Set<ItemPedido> getItemPedidos(){
        return itemPedidos;
    }

    public Set<Produto> getProdutos(){
        return itemPedidos.stream().map(i -> i.getProduto()).collect(Collectors.toSet());
    }

}
