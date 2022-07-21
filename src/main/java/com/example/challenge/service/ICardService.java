package com.example.challenge.service;

import com.example.challenge.dto.CardDto;
import com.example.challenge.dto.CardDtoCreate;

public interface ICardService {

    CardDto save(CardDtoCreate cardDtoCreate);

    void delete(Long id);
}
