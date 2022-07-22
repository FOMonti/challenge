package com.example.challenge.service;

import com.example.challenge.dto.OperationDto;
import com.example.challenge.dto.OperationDtoCreate;
import com.example.challenge.model.Card;

import java.util.List;

public interface IOperationService {

    OperationDto save(OperationDtoCreate operationDtoCreate);

    void delete(Long id);

    List<OperationDto> getOperationsBy(Long cardNumber);

    List<OperationDto> getAll();

    double getRate(Card card);
}
