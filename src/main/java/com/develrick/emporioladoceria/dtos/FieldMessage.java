package com.develrick.emporioladoceria.dtos;

public class FieldMessage {
    private String nome;
    private String mensagem;


    public FieldMessage(String nome,String mensagem){
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public String getMensagem() {
        return mensagem;
    }
}
