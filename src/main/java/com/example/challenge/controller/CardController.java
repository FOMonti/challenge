package com.example.challenge.controller;

import com.example.challenge.dto.CardDto;
import com.example.challenge.dto.CardDtoCreate;
import com.example.challenge.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final ICardService cardService;

    @Autowired
    public CardController(ICardService iCardService) {
        this.cardService = iCardService;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CardDtoCreate cardDtoCreate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(cardDtoCreate));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        cardService.delete(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
