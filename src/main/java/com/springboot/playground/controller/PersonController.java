package com.springboot.playground.controller;

import com.springboot.playground.dto.PersonDto;
import com.springboot.playground.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
//@EnableScheduling
@RestController
@RequestMapping(PersonController.API_ROOT)
public class PersonController {

    static final String API_ROOT = "api/v1/person";
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @CacheEvict(value = "persons")
    @PostMapping("")
    public ResponseEntity savePerson(@Valid @RequestBody PersonDto personDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(BAD_REQUEST);
        }

        System.out.println();
        log.info("****** Cache entry 'persons' is cleared when adding new movie ******");
        log.info("****** Next time 'api/v1/person/all' is called, it will cache all movies again, included this new entry ******");
        System.out.println();

        log.info("Saving new person ...");
        return personService.savePerson(personDto);
    }

    @Cacheable("persons")
    @GetMapping("/all")
    public ResponseEntity<List<PersonDto>> getAllPersons() {
        log.info("Getting all persons");

        System.out.println();
        log.info("Getting all persons");
        log.info("******* If no new entry, I will only be called once *******");
        System.out.println();

        return personService.getAllPersons();
    }

    @Cacheable(value = "personId")
    @GetMapping("/{personId}")
    public ResponseEntity getPersonByPersonId(@PathVariable Integer personId, @RequestHeader HttpHeaders headers) {
        log.info("Getting person by id : " + personId);

        System.out.println();
        log.info("******* I will only be called once per id *******");
        log.info("Getting person by title " + personId);
        System.out.println();

        return personService.getPersonByPersonId(personId);
    }

    @Caching(evict = {
            @CacheEvict(value = "persons", allEntries = true),
            @CacheEvict(value = "personId", allEntries = true)})
    @DeleteMapping("")
    public ResponseEntity deleteAllPersons() {
        log.info("Deleting all persons");
        log.info("Clearing all caches");
        return personService.deleteAllPersons();
    }

    /*
    //Clear all cachentries every 120s.
    @Scheduled(fixedRate = 120000)
    @Caching(evict = {
            @CacheEvict(value = "persons", allEntries = true),
            @CacheEvict(value = "personById", allEntries = true),
            @CacheEvict(value = "movieByYear", allEntries = true)})
    public void clearAllCaches() {
        System.out.println();
        log.info("******* Clearing all entries with schedule *******");
        System.out.println();
    }

    @GetMapping("/year/{year}")
    @CachePut("movieByYear")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieByYear(@PathVariable Integer year) {
        System.out.println();
        log.info("******* I will run every time and clear all cachentries on movieByYear *******");
        log.info("******* And at the same time update it with this new value *******");
        log.info("Getting movie by year " + year);
        System.out.println();
        return movieService.getMovieByYear(year);
    }*/
}

