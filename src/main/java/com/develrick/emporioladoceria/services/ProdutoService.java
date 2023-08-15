package com.develrick.emporioladoceria.services;

import com.develrick.emporioladoceria.dtos.ProdutoDTO;
import com.develrick.emporioladoceria.entities.Produto;
import com.develrick.emporioladoceria.services.exceptions.RecursoNaoEncontradoException;
import com.develrick.emporioladoceria.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id){
        Produto p = produtoRepository.findById(id).orElseThrow(
                () ->  new RecursoNaoEncontradoException("Recurso não existe."));
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
        copiaDTO(dto,p);
        p = produtoRepository.save(p);
        return new ProdutoDTO(p);
    }

    @Transactional
    public ProdutoDTO update(Long id,ProdutoDTO dto){
        try {
            Produto entidade = produtoRepository.getReferenceById(id);
            copiaDTO(dto, entidade);
            entidade = produtoRepository.save(entidade);
            return new ProdutoDTO(entidade);
        } catch (EntityNotFoundException e){
            throw new RecursoNaoEncontradoException("Recurso não existe.");
        }
    }

    @Transactional
    public void deleteById(Long id){
        if (produtoRepository.existsById(id) == false) {
                throw new RecursoNaoEncontradoException("Recurso não existe");
            }
        produtoRepository.deleteById(id);
    }

    private void copiaDTO(ProdutoDTO dto, Produto entidade){
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        entidade.setPreco(dto.getPreco());
        entidade.setImgUrl(dto.getImgUrl());
    }

}
