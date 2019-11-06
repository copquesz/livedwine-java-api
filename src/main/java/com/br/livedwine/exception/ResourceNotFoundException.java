package com.br.livedwine.exception;

/**
 * @author Lucas Copque
 * @version 1.0
 * @since 06/11/2019
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
