package com.example.challenge.mapper;

import com.example.challenge.dto.CardDto;
import com.example.challenge.dto.CardDtoBasic;
import com.example.challenge.dto.CardDtoCreate;
import com.example.challenge.model.Card;
import com.example.challenge.util.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardMapper {

    public CardDto cardEntity2Dto(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setNumber(card.getNumber());
        cardDto.setBrand(card.getBrand().name());
        cardDto.setExpirationDate(card.getExpirationDate());
        return cardDto;
    }

    public Card cardCreatDto2Entity(CardDtoCreate cardDtoCreate) {
        Card card = new Card();
        card.setNumber(cardDtoCreate.getNumber());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        card.setExpirationDate(LocalDate.parse(cardDtoCreate.getExpirationDate(), formatter));
        card.setBrand(getBrand(cardDtoCreate.getBrand()));
        return card;
    }

    public List<CardDtoBasic> cardListEntity2DtoList(List<Card> cards) {
        List<CardDtoBasic> cardDtos = new ArrayList<>();
        for (Card card : cards) {
            cardDtos.add(cardEntity2DtoBasic(card));
        }
        return cardDtos;
    }

    private CardDtoBasic cardEntity2DtoBasic(Card card) {
        CardDtoBasic cardDto = new CardDtoBasic();
        cardDto.setId(card.getId());
        cardDto.setNumber(card.getNumber());
        cardDto.setBrand(card.getBrand().name());
        cardDto.setExpirationDate(card.getExpirationDate());
        return cardDto;
    }

    private Brand getBrand(String brand) {
        for (Brand enumBrand : Brand.values()) {
            if (enumBrand.toString().equals(brand.toUpperCase())) {
                return enumBrand;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "brand not found");
    }
}
