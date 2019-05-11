package com.springboot.playground.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Location {

    private String country;
    private String cityname;
    private String streetname;
    private Integer houseNumber;
}
