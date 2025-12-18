package com.breno.crudoptometrista.exception;

public class CpfJaCadastradoException extends RuntimeException {
    private static final long serialVersionUID= 1L;
    public CpfJaCadastradoException(String message) {
        super(message);
    }
}
