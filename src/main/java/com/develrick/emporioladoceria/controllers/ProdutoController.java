package com.develrick.emporioladoceria.controllers;

import com.develrick.emporioladoceria.dtos.ProdutoDTO;
import com.develrick.emporioladoceria.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


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
    public ResponseEntity<ProdutoDTO> save(@Valid @RequestBody ProdutoDTO dto){
        ProdutoDTO produtoDTO = produtoService.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produtoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable  Long id,@Valid @RequestBody ProdutoDTO dto){
        ProdutoDTO produtoDTO = produtoService.update(id,dto);
        return ResponseEntity.ok(produtoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleleById(@PathVariable Long id){
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
