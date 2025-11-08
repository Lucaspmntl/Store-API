package com.selection.process.store.api.handler;

import com.selection.process.store.api.exception.EmptyFieldException;
import com.selection.process.store.api.exception.NegativeValueException;
import com.selection.process.store.api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<String> resourceNotFound(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recurso não encontrado.");
    }

    @ExceptionHandler(EmptyFieldException.class)
    private ResponseEntity<String> emptyField(EmptyFieldException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Campo obrigatório não vazio!");
    }

    private ResponseEntity<String> negativeValue(NegativeValueException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O valor não pode ser negativo");
    }
}
