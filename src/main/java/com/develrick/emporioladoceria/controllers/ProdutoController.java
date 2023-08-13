package com.develrick.emporioladoceria.controllers;

import com.develrick.emporioladoceria.dtos.ProdutoDTO;
import com.develrick.emporioladoceria.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        ProdutoDTO dto =  produtoService.findById(id);
        return ResponseEntity.ok(dto);
    }


    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> findAll(Pageable pageable){
        Page<ProdutoDTO> listDTO = produtoService.findAll(pageable);
        return ResponseEntity.ok(listDTO);
    }


    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO dto){
        ProdutoDTO produtoDTO = produtoService.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produtoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
    }








}
