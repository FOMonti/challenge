package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CardDtoBasic {

    private Long id;

    private Long number;

    private String brand;

    private LocalDate expirationDate;
}
