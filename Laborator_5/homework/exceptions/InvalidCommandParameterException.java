package org.example.homework.exceptions;

public class InvalidCommandParameterException extends Exception {
    public InvalidCommandParameterException(String message) {
        super(message);
    }
}