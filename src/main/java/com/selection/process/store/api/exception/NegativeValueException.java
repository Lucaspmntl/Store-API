package com.selection.process.store.api.exception;

public class NegativeValueException extends RuntimeException {

    public NegativeValueException(){
      super("O valor informado não pode ser negativo");
    }
    public NegativeValueException(String message) {
        super(message);
    }
}
