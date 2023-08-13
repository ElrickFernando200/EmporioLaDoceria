package com.develrick.emporioladoceria.services;

import com.develrick.emporioladoceria.dtos.ProdutoDTO;
import com.develrick.emporioladoceria.entities.Produto;
import com.develrick.emporioladoceria.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ProdutoDTO> findAll(Pageable pageable){
        Page<Produto> resultado = produtoRepository.findAll(pageable);
        return resultado.map(p -> new ProdutoDTO(p));
    }

    @Transactional
    public ProdutoDTO save(ProdutoDTO dto){
        Produto p = new Produto();
        p.setNome(dto.getNome());
        p.setDescricao(dto.getDescricao());
        p.setPreco(dto.getPreco());
        p.setImgUrl(dto.getImgUrl());
        p = produtoRepository.save(p);
        return new ProdutoDTO(p);
    }

    public ProdutoDTO update(ProdutoDTO dto){
        Produto entidade = new Produto();
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        entidade.setPreco(dto.getPreco());
        entidade.setImgUrl(dto.getImgUrl());
        entidade = produtoRepository.save(entidade);
        return new ProdutoDTO(entidade);
    }

}
