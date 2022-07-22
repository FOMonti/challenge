package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HolderCompleteDto extends HolderDto {

    private List<CardDtoBasic> cardDtos;
}
