package com.project.nosql.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandle {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StantanderError> objNotFound(ObjectNotFoundException ex, HttpServletRequest resq) {

        StantanderError error = new StantanderError(System.currentTimeMillis(), "Não encontrado", ex.getMessage(), resq.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<StantanderError> formatError(ConversionFailedException ex, HttpServletRequest resq) {

        StantanderError error = new StantanderError(System.currentTimeMillis(), "Não encontrado", ex.getMessage(), resq.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
