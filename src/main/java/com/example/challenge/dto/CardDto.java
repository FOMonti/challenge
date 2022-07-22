package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CardDto extends CardDtoBasic {

    private HolderDto holderDto;
}
