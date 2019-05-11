package com.springboot.playground.entity;

import com.springboot.playground.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String firstname;
    private String lastname;
    private Integer age;
    private Gender gender;
    @OneToOne
    private Location location;

}
