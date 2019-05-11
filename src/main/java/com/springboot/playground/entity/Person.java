package com.springboot.playground.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Person {

    private String firstname;
    private String lastname;
    private Integer age;
}
