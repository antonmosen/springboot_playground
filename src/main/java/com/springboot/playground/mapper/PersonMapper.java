package com.springboot.playground.mapper;

import com.springboot.playground.dto.PersonDto;
import com.springboot.playground.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "personDto.locationDto.id", target = "location.id")
    @Mapping(source = "personDto.locationDto.country", target = "location.country")
    @Mapping(source = "personDto.locationDto.cityname", target = "location.cityname")
    @Mapping(source = "personDto.locationDto.streetname", target = "location.streetname")
    @Mapping(source = "personDto.locationDto.houseNumber", target = "location.houseNumber")
    Person personDtoToPerson(PersonDto personDto);

    PersonDto personToPersonDto(Person person);

}
