package com.springboot.playground.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {
    @Override
    public ResponseEntity healthCheck() {
        return new ResponseEntity("System is up and running",HttpStatus.OK);
    }
}
