package com.stefan.salaryapp.config;

import com.stefan.salaryapp.exceptions.ExceptionResponse;
import com.stefan.salaryapp.exceptions.IncorrectCredentials;
import com.stefan.salaryapp.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseBody
    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse resourceNotFoundHandler(ResourceNotFound ex) {
        return new ExceptionResponse(ex.getMessage(), LocalDateTime.now());
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse illegalArgumentException(IllegalArgumentException ex) {
        return new ExceptionResponse(ex.getMessage(), LocalDateTime.now());
    }

    @ResponseBody
    @ExceptionHandler(IncorrectCredentials.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionResponse incorrectCredentials(IncorrectCredentials ex) {
        return new ExceptionResponse(ex.getMessage(), LocalDateTime.now());
    }

}
