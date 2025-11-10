package com.selection.process.store.api.handler;

import com.selection.process.store.api.dto.response.ValidationErrorResponseDTO;
import com.selection.process.store.api.exception.EmptyFieldException;
import com.selection.process.store.api.exception.NegativeValueException;
import com.selection.process.store.api.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ValidationErrorResponseDTO> MethodArgumentNotValidHandler(MethodArgumentNotValidException exception) {

        ValidationErrorResponseDTO response =
                new ValidationErrorResponseDTO("Erro de validação, verifique os campos enviados.");

        List<FieldError> exceptionField = exception.getBindingResult().getFieldErrors();

        for (FieldError exceptionFields : exceptionField){
            String field = exceptionFields.getField();
            String message = exceptionFields.getDefaultMessage();
            Object rejectedValue = exceptionFields.getRejectedValue();

            response.addFieldErrors(field, message, rejectedValue);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<String> resourceNotFound(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
