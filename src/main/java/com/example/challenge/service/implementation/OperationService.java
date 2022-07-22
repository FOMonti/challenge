package com.example.challenge.service.implementation;

import com.example.challenge.dto.OperationDto;
import com.example.challenge.dto.OperationDtoCreate;
import com.example.challenge.mapper.OperationMapper;
import com.example.challenge.model.Card;
import com.example.challenge.model.Operation;
import com.example.challenge.repository.CardRepository;
import com.example.challenge.repository.OperationRepository;
import com.example.challenge.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService implements IOperationService {

    private final OperationRepository operationRepository;

    private final CardRepository cardRepository;
    private final OperationMapper operationMapper;

    @Autowired
    public OperationService(OperationRepository operationRepository, OperationMapper operationMapper,
                            CardRepository cardRepository) {
        this.operationMapper = operationMapper;
        this.operationRepository = operationRepository;
        this.cardRepository = cardRepository;
    }


    @Override
    public OperationDto save(OperationDtoCreate operationDtoCreate) {
        Optional<Card> card = cardRepository.findById(operationDtoCreate.getCardId());
        card.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Operation operation = operationMapper.operationDtoCreate2Entity(operationDtoCreate);
        operation.setCard(card.get());
        operationRepository.save(operation);
        return operationMapper.operationEntity2Dto(operation);
    }

    @Override
    public void delete(Long id) {
        Optional<Operation> operation = operationRepository.findById(id);
        operation.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        operationRepository.delete(operation.get());
    }

    @Override
    public List<OperationDto> getOperationsBy(Long cardNumber) {
        Optional<Card> card = cardRepository.findByNumber(cardNumber);
        card.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        List<Operation> operations = operationRepository.getOperationByCard(card.get());
        return operationMapper.operationEntityList2DtoList(operations);
    }

    @Override
    public List<OperationDto> getAll() {
        List<Operation> operations = operationRepository.findAll();
        return operationMapper.operationEntityList2DtoList(operations);
    }


    @Override
    public double getRate(Card card) {
        return 0;
    }
}
