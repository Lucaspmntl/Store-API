package com.selection.process.store.api.exception;

public class EmptyFieldException extends RuntimeException {

    public EmptyFieldException(){
      super("Campo obrigatório não preenchido!");
    }
    public EmptyFieldException(String message) {
        super(message);
    }

}
