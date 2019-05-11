package com.springboot.playground.controller;

import com.springboot.playground.dto.PersonDto;
import com.springboot.playground.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(PersonController.API_ROOT)
public class PersonController {

    static final String API_ROOT = "api/v1/person";
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("")
    public ResponseEntity savePerson(@RequestBody @Valid PersonDto personDto){
        log.info("Saving new person ...");
        return personService.savePerson(personDto);
    }


}
