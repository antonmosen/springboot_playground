package com.springboot.playground.service;

import com.springboot.playground.dto.PersonDto;
import com.springboot.playground.entity.Person;
import com.springboot.playground.mapper.PersonMapper;
import com.springboot.playground.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ResponseEntity savePerson(PersonDto personDto) {

        Person person = PersonMapper.INSTANCE.personDtoToPerson(personDto);
        Person savedPerson = personRepository.save(person);

        if (savedPerson.getId() == null) {
            return new ResponseEntity<>("Could not save new person", HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>("Saving person was successful", HttpStatus.OK);

    }
}
