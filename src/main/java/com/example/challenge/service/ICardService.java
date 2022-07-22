package com.example.challenge.service;

import com.example.challenge.dto.CardDto;
import com.example.challenge.dto.CardDtoCreate;

public interface ICardService {

    CardDto save(CardDtoCreate cardDtoCreate);

    CardDto getById(Long id);

    void delete(Long id);
}
