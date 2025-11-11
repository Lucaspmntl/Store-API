package com.selection.process.store.api.dto.response;

public class GenericResponseDTO {

    private String message;
    private int status;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getStatus() {return status;}
    public void setStatus(int status) {this.status = status;}

    public GenericResponseDTO(){}
    public GenericResponseDTO(String message){
        this.message = message;
        this.status = 200;
    }
    public GenericResponseDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }

}
