package com.stefan.salaryapp.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String exceptionMessage) {
        super(exceptionMessage);
    }
}
