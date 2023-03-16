package com.academy.service;

public class CustomerNotAdultException extends Exception {
    public CustomerNotAdultException(String errorMessage) {
        super(errorMessage);
    }
}
