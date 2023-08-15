package com.develrick.emporioladoceria.controllers.handlers;

import com.develrick.emporioladoceria.dtos.CustomError;
import com.develrick.emporioladoceria.services.exceptions.RecursoNaoEncontradoException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
