package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OperationDtoCreate {

    @NotNull(message = "card must no be null")
    private Long cardId;

    @NotNull(message = "consumption must no be null")
    private Double consumption;

    @NotNull(message = "Consultion date must no be null")
    private String consuptionDay;
}
