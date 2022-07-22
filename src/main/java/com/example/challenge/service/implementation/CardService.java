package com.example.challenge.service.implementation;

import com.example.challenge.dto.CardDto;
import com.example.challenge.dto.CardDtoCreate;
import com.example.challenge.mapper.CardMapper;
import com.example.challenge.mapper.HolderMapper;
import com.example.challenge.model.Card;
import com.example.challenge.model.Holder;
import com.example.challenge.repository.CardRepository;
import com.example.challenge.repository.HolderRepository;
import com.example.challenge.service.ICardService;
import com.example.challenge.util.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {

    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    private final MessageHandler messageHandler;
    private final HolderRepository holderRepository;
    private final HolderMapper holderMapper;

    @Autowired
    public CardService(CardMapper cardMapper, CardRepository cardRepository, HolderRepository holderRepository,
                       MessageHandler messageHandler, HolderMapper holderMapper) {
        this.cardMapper = cardMapper;
        this.cardRepository = cardRepository;
        this.holderRepository = holderRepository;
        this.messageHandler = messageHandler;
        this.holderMapper = holderMapper;
    }

    @Override
    public CardDto save(CardDtoCreate cardDtoCreate) {
        Optional<Holder> holder = holderRepository.findById(cardDtoCreate.getHolderId());
        holder.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Card card = cardMapper.cardCreatDto2Entity(cardDtoCreate);
        card.setCardHolder(holder.get());
        cardRepository.save(card);

        CardDto cardDto = cardMapper.cardEntity2Dto(card);
        cardDto.setHolderDto(holderMapper.holderEntity2Dto(holder.get()));
        return cardDto;
    }

    @Override
    public CardDto getById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        card.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        CardDto cardDto = cardMapper.cardEntity2Dto(card.get());
        cardDto.setHolderDto(holderMapper.holderEntity2Dto(card.get().getCardHolder()));
        return cardDto;
    }

    @Override
    public List<CardDto> getAll() {
        List<Card> cards = cardRepository.findAll();
        return cardMapper.cardListEntity2DtoList(cards);
    }


    @Override
    public void delete(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        card.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        cardRepository.delete(card.get());
    }
}
