package com.develrick.emporioladoceria.controllers;

import com.develrick.emporioladoceria.dtos.ProdutoDTO;
import com.develrick.emporioladoceria.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ProdutoDTO findById(@PathVariable Long id){
        return produtoService.findById(id);
    }


    @GetMapping
    public List<ProdutoDTO> findAll(){
        return produtoService.findAll();
    }





}
