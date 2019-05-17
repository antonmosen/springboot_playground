package com.springboot.playground.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonTypeName("person")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "firstname",
        "lastname",
        "age",
        "gender",
        "location"
})
@Data
public class PersonDto {

    @NotEmpty
    @JsonProperty("firstname")
    private String firstname;
    @NotEmpty
    @JsonProperty("lastname")
    private String lastname;
    @Min(1)
    @NotNull
    @JsonProperty("age")
    private Integer age;
    @NotEmpty
    @JsonProperty("gender")
    private String gender;
    @NotNull
    @JsonProperty("location")
    @Valid //Child objects needs to be annotaded with @Valid in order to be validated. See PersonController.
    private LocationDto locationDto;
}