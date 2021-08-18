package com.company.exceptions;

public class NotMathematicalOperation extends IllegalArgumentException {
    public NotMathematicalOperation(String message) {
        super(message);
    }
}
