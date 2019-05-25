package com.springboot.playground.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class PlaygroundSessionException extends RuntimeException {

    public PlaygroundSessionException(String exception) {
        super(exception);
    }
}

