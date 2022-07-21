package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class HolderDtoCreat {

    @NotNull(message = "firstName must no be null")
    private String firstName;

    @NotNull(message = "lastName must no be null")
    private String lastName;
}
