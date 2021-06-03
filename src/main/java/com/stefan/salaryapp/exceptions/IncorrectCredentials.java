package com.stefan.salaryapp.exceptions;

public class IncorrectCredentials  extends RuntimeException {

    public IncorrectCredentials(String exceptionMessage) {
        super(exceptionMessage);
    }

}
