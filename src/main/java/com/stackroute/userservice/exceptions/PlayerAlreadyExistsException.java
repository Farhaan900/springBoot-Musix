package com.stackroute.userservice.exceptions;

public class PlayerAlreadyExistsException extends Exception {
    public PlayerAlreadyExistsException(String message) {
        super(message);
    }
}
