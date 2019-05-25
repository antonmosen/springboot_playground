package com.springboot.playground.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/*
 * This class maps all errors in application to custom error response.
 * When annotated with @RestControllerAdvice, error thrown from controllers are directly
 * directed to this class.
 *
 * All exception thrown outside of controllers, from filters for example,
 * are directed via GlobalErrorHandler.java and then directed to here.
 *
 * */
@RestControllerAdvice
public class CustomResponseEntityErrorMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handlePersonNotFoundException(PersonNotFoundException ex, WebRequest request) {
        return responseEntityError(request, NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(PlaygroundSessionException.class)
    public final ResponseEntity<ErrorDetails> handlePlaygroundSessionException(PlaygroundSessionException ex, WebRequest request) {
        return responseEntityError(request, INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        return responseEntityError(request, INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ResponseEntity<ErrorDetails> responseEntityError(WebRequest request, HttpStatus httpStatus, String errorMessage) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), errorMessage, request.getDescription(false), httpStatus, httpStatus.value());
        return new ResponseEntity<>(errorDetails, httpStatus);
    }
}
