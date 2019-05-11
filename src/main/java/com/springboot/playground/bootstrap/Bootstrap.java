package com.springboot.playground.bootstrap;

import com.springboot.playground.entity.Location;
import com.springboot.playground.entity.Person;
import com.springboot.playground.enums.Gender;
import com.springboot.playground.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
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
