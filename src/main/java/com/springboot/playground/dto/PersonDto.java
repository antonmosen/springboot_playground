package com.springboot.playground.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@JsonTypeName("person")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstname",
        "lastname",
        "age",
        "gender",
        "location"
})
@Data
public class PersonDto {

    @Null
    @JsonProperty("id")
    private Integer id;
    @NotNull
    @JsonProperty("firstname")
    private String firstname;
    @NotNull
    @JsonProperty("lastname")
    private String lastname;
    @NotNull
    @JsonProperty("age")
    @NotNull
    private Integer age;
    @JsonProperty("gender")
    @NotNull
    private String gender;
    @JsonProperty("location")
    @NotNull
    private LocationDto locationDto;
}