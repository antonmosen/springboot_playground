package com.springboot.playground.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {
    @Override
    public String healtCheck() {
        return HttpStatus.OK.toString();
    }
}
