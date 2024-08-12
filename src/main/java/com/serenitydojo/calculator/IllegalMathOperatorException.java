package com.serenitydojo.calculator;

public class IllegalMathOperatorException extends RuntimeException {
    public IllegalMathOperatorException(String message) {
        super(message);
    }
}