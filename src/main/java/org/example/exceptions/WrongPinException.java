package org.example.exceptions;

public class WrongPinException extends Exception {
    public WrongPinException(String message) {
        super(message);
    }
}
