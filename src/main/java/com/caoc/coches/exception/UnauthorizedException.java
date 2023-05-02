package com.caoc.coches.exception;


public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("No tiene los permisos necesarios.");
    }
}
