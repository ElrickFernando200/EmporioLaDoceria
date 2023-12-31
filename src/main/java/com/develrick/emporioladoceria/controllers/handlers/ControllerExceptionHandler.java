package com.develrick.emporioladoceria.controllers.handlers;

import com.develrick.emporioladoceria.dtos.CustomError;
import com.develrick.emporioladoceria.dtos.ValidationError;
import com.develrick.emporioladoceria.services.exceptions.BancoDeDadosException;
import com.develrick.emporioladoceria.services.exceptions.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<CustomError> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(Instant.now(),status.value(),e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(BancoDeDadosException.class)
    public ResponseEntity<CustomError> bancoDeDados(BancoDeDadosException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError error = new CustomError(Instant.now(),status.value(),e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(error);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> validacao(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(Instant.now(),status.value(),"Dados Invalidos",request.getRequestURI());
        e.getBindingResult().getFieldErrors().stream().forEach(x -> error.addErros(x.getField(),x.getDefaultMessage()));
        return ResponseEntity.status(status).body(error);

    }




}
