package com.selection.process.store.api.dto.response;

public class GenericIdResponseDTO {

    private String message;
    private long id;
    private int status;

    public String getMessage() { return message; }
    public long getId() { return id; }
    public int getStatus() {return status;}

    public GenericIdResponseDTO(){}
    public GenericIdResponseDTO(String message, long id, int status) {
        this.message = message;
        this.id = id;
        this.status = status;
    }
}
