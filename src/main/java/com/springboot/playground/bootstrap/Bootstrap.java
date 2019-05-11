package com.springboot.playground.bootstrap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.playground.entity.Location;
import com.springboot.playground.entity.Person;
import com.springboot.playground.enums.Gender;
import com.springboot.playground.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Slf4j
//@Component
//@Profile("!prod")
public class Bootstrap implements CommandLineRunner {

    private PersonRepository personRepository;

    @Autowired
    public Bootstrap(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) {

        if (personRepository.count() == 0) {
            log.info("Populating new test data");

            Person person = newPerson();
            log.info("Trying to save new person ...");
            personRepository.save(person);
            log.info("New person saved ...");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                System.out.println(objectMapper.writeValueAsString(person));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            log.info("Test data already exist");
        }
    }

    private Person newPerson() {
        return Person.builder()
                .age(25)
                .firstname("Anton")
                .lastname("Lastname")
                .gender(Gender.MALE)
                .location(Location
                        .builder()
                        .cityname("Ronneby")
                        .country("Sweden")
                        .houseNumber(12)
                        .streetname("Streetichname")
                        .build()).build();
    }


}
