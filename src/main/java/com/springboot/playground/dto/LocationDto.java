package com.springboot.playground.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    @JsonProperty("country")
    private String country;
    @NotEmpty
    @JsonProperty("cityname")
    private String cityname;
    @NotEmpty
    @JsonProperty("streetname")
    private String streetname;
    @Min(1)
    @NotNull
    @JsonProperty("houseNumber")
    private Integer houseNumber;

}