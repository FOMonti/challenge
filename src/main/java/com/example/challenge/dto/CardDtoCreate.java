package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CardDtoCreate {

    @NotNull(message = "number must no be null")
    private Long number;

    @NotNull(message = "holder must no be null")
    private Long holderId;

    @NotNull(message = "brand must no be null")
    private String brand;

    @NotNull(message = "Expiration date must no be null")
    private String expirationDate;
}
