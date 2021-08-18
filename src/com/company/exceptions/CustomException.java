package com.company.exceptions;

public class CustomException extends IndexOutOfBoundsException {
    public CustomException(String message) {
        super(message);
    }
}
