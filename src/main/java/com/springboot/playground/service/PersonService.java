package com.springboot.playground.service;

import com.springboot.playground.dto.PersonDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    ResponseEntity savePerson(PersonDto personDto);

    ResponseEntity getPersonByPersonId(Integer personId);

    ResponseEntity<List<PersonDto>> getAllPersons();

    ResponseEntity deleteAllPersons();
}
