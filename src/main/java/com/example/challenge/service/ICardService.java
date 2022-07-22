package com.example.challenge.service;

import com.example.challenge.dto.CardDto;
import com.example.challenge.dto.CardDtoCreate;
import com.example.challenge.model.Card;

import java.util.List;

public interface ICardService {

    CardDto save(CardDtoCreate cardDtoCreate);

    CardDto getById(Long id);

    List<CardDto> getAll();

    void delete(Long id);
}
