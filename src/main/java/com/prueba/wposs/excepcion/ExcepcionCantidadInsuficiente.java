package com.prueba.wposs.excepcion;

public class ExcepcionCantidadInsuficiente extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionCantidadInsuficiente(String mensaje) {
        super(mensaje);
    }
}
