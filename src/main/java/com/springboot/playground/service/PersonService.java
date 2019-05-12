package com.springboot.playground.service;

import com.springboot.playground.dto.PersonDto;
import org.springframework.http.ResponseEntity;

public interface PersonService {

    ResponseEntity savePerson(PersonDto person);

    ResponseEntity getPersonByPersonId(Integer personId);
}
