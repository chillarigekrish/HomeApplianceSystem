package com.smarthome.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidApplianceTypeException.class)
    public ResponseEntity<String> handleInvalidApplianceTypeException(InvalidApplianceTypeException ex) {
        return ResponseEntity.badRequest().body("{\"error\":\"" + ex.getMessage() + "\"}");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
