package com.selection.process.store.api.dto.response;

public class GenericIdResponseDTO {

    private String message;
    private long respectiveId;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public long getRespectiveId() { return respectiveId; }
    public void setRespectiveId(long respectiveId) { this.respectiveId = respectiveId; }

    public GenericIdResponseDTO(){}

    public GenericIdResponseDTO(String message, long respectiveId) {
        this.message = message;
        this.respectiveId = respectiveId;
    }
}
