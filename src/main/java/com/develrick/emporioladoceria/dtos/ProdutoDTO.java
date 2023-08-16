package com.develrick.emporioladoceria.dtos;


import com.develrick.emporioladoceria.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


public class ProdutoDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome tem que ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo Requerido")
    private String nome;
    @Size(min = 10, message = "Descricao deve ter no minino 10 caracteres")
    @NotBlank(message = "Descricao não pode ser nulo")
    private String descricao;

    @Positive(message = "O preco deve ser positivo")
    @NotNull(message = "Valor não pode ser Nulo")
    private Double preco;
    private String imgUrl;


    public ProdutoDTO(){}

    public ProdutoDTO(Long id, String nome, String descricao,Double preco, String imgUrl){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }
    public ProdutoDTO(Produto produto){
        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        preco = produto.getPreco();
        imgUrl = produto.getImgUrl();
    }

    public Long getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public Double getPreco(){
        return preco;
    }

    public String getImgUrl(){
        return imgUrl;
    }

}
