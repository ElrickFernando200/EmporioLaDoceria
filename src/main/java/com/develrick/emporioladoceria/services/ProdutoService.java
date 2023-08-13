package com.develrick.emporioladoceria.services;

import com.develrick.emporioladoceria.dtos.ProdutoDTO;
import com.develrick.emporioladoceria.entities.Produto;
import com.develrick.emporioladoceria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Controller
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){
        Produto p = produtoRepository.findById(id).get();
        return new ProdutoDTO(p);
    }

    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAll(){
        return  produtoRepository.findAll().stream().map(p -> new ProdutoDTO(p)).toList();
    }

}
