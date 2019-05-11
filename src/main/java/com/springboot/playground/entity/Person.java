package com.springboot.playground.entity;

import com.springboot.playground.enums.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
public class Person {

    private String firstname;
    private String lastname;
    private Integer age;
    private Gender gender;
    @OneToOne
    private Location location;

}
