package com.smarthome.exceptions;

public class InvalidApplianceTypeException extends RuntimeException {
    public InvalidApplianceTypeException(String message) {
        super(message);
    }
}
