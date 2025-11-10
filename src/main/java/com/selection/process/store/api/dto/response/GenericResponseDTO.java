package com.selection.process.store.api.dto.response;

public class GenericResponseDTO {

    private String message;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public GenericResponseDTO(){}

    public GenericResponseDTO(String message){
        this.message = message;
    }
}
