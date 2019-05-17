package com.springboot.playground.controller;

import com.springboot.playground.dto.PersonDto;
import com.springboot.playground.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

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
    public ResponseEntity savePerson(@Valid @RequestBody PersonDto personDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(BAD_REQUEST);
        }

        log.info("Saving new person ...");
        return personService.savePerson(personDto);
    }

    @GetMapping("/{personId}")
    public ResponseEntity getPersonByPersonId(@PathVariable Integer personId, @RequestHeader HttpHeaders headers) {
        log.info("Getting person by id : " + personId);
        return personService.getPersonByPersonId(personId);
    }
}
