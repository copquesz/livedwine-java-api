package com.br.livedwine.handler;

import com.br.livedwine.error.ErrorDetails;
import com.br.livedwine.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

/**
 * @author Lucas Copque
 * @version 1.0
 * @since 06/11/2019
 */
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDetails details = ErrorDetails.
                Builder.
                create().
                timestamp(new Date().getTime()).
                status(HttpStatus.NOT_FOUND.value()).
                title("Resource Not Found").
                message(ex.getMessage()).
                locale(ex.getClass().getName()).
                build();

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

}
