package com.selection.process.store.api.dto.response;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém o corpo que será retornado em caso de MethodArgumentNotValidException.
 */
public class ValidationErrorResponseDTO {

    private String message;
    private int status;

    // Esta lista contém todos as exceptions que serão retornados no caso de erro de validação
    private List<FieldErrorDTO> errors;

    public ValidationErrorResponseDTO(){}

    public ValidationErrorResponseDTO(String message){
        this.message = message;
        this.status = 400;
        this.errors =  new ArrayList<>();
    }

    /**
     * O "construtor" da lista {@code errors} para simplificar as operações.
     * @param field o campo que foi invalidade (exemplo: quantity, name, price...).
     * @param message a mensagem de erro que será exposta ao usuário.
     * @param rejectedValue o valor que foi rejeitado (exemplo: price = 0).
     */
    public void addFieldErrors(String field, String message, Object rejectedValue){
        this.errors.add((new FieldErrorDTO(message, field, rejectedValue)));
    }

    public String getMessage() {return message;}
    public int getStatus() {return status;}
    public List<FieldErrorDTO> getErrors() {return errors;}

    /**
     * Classe estática que se refere a um campo de erro específico dentro da lista de errors.
     */
    public static class FieldErrorDTO {
        private String field;
        private String message;
        private Object rejectedValue;

        public FieldErrorDTO(){}
        public FieldErrorDTO(String message, String field, Object rejectedValue) {
            this.field = field;
            this.message = message;
            this.rejectedValue = rejectedValue;
        }

        public String getField() {return field;}
        public String getMessage() {return message;}
        public Object getRejectedValue() {return rejectedValue;}
    }
}
