package com.springboot.playground.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.validation.constraints.NotNull;

@JsonTypeName("location")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "country",
        "cityname",
        "streetname",
        "houseNumber"
})
@Data
public class LocationDto {

    @NotNull
    @JsonProperty("country")
    private String country;
    @NotNull
    @JsonProperty("cityname")
    private String cityname;
    @NotNull
    @JsonProperty("streetname")
    private String streetname;
    @NotNull
    @JsonProperty("houseNumber")
    private Integer houseNumber;

}