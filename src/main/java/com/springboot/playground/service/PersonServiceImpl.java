package com.springboot.playground.service;

import com.springboot.playground.dto.PersonDto;
import com.springboot.playground.entity.Person;
import com.springboot.playground.exception.PersonNotFoundException;
import com.springboot.playground.mapper.PersonMapper;
import com.springboot.playground.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            return new ResponseEntity<Object>("Could not save new person", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>("Saving person was successful", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getPersonByPersonId(Integer personId) {

        Optional<Person> person = personRepository.findById(personId);

        return person.<ResponseEntity>
                map(response -> new ResponseEntity<>(
                PersonMapper.INSTANCE.personToPersonDto(response), HttpStatus.OK))
                .orElseThrow(() -> new PersonNotFoundException("Person with id " + personId + " was not found"));
    }
}
