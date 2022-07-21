package com.example.challenge.mapper;

import com.example.challenge.dto.CardDto;
import com.example.challenge.dto.CardDtoCreate;
import com.example.challenge.model.Card;
import com.example.challenge.util.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private Brand getBrand(String brand) {
        for (Brand enumBrand : Brand.values()) {
            if (enumBrand.toString().equals(brand.toUpperCase())) {
                return enumBrand;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "brand not found");
    }
}
