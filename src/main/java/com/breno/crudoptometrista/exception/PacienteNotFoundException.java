package com.breno.crudoptometrista.exception;

public class PacienteNotFoundException extends RuntimeException {

    private static final long serialVersionUID= 1L;
    public PacienteNotFoundException(Long id) {
        super("Paciente não encontrado com id: " + id);
    }
}
