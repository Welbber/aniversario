package com.github.aniversario.controller;

import com.github.aniversario.entities.ErrorMessage;
import exception.BirthdayPersonNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final int FIRST_ERROR_INDEX = 0;

    @ExceptionHandler(BirthdayPersonNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(BirthdayPersonNotFoundException productsNotFoundException) {
        ErrorMessage error = new ErrorMessage();
        error.setMessage(productsNotFoundException.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ErrorMessage errorDetails = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), errorList.get(FIRST_ERROR_INDEX));
        return handleExceptionInternal(ex, errorDetails, headers, HttpStatus.BAD_REQUEST, request);
    }

}

