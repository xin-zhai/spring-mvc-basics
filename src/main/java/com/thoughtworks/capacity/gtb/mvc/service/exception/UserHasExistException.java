package com.thoughtworks.capacity.gtb.mvc.service.exception;

public class UserHasExistException extends RuntimeException{
    public UserHasExistException(String message) {
        super(message);
    }
}
