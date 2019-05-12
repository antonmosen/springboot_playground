package com.springboot.playground.mapper;

import com.springboot.playground.dto.PersonDto;
import com.springboot.playground.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "personDto.locationDto.country", target = "location.country")
    @Mapping(source = "personDto.locationDto.cityname", target = "location.cityname")
    @Mapping(source = "personDto.locationDto.streetname", target = "location.streetname")
    @Mapping(source = "personDto.locationDto.houseNumber", target = "location.houseNumber")
    Person personDtoToPerson(PersonDto personDto);

    @Mapping(source = "person.location.country", target = "locationDto.country")
    @Mapping(source = "person.location.cityname", target = "locationDto.cityname")
    @Mapping(source = "person.location.streetname", target = "locationDto.streetname")
    @Mapping(source = "person.location.houseNumber", target = "locationDto.houseNumber")
    PersonDto personToPersonDto(Person person);

}
