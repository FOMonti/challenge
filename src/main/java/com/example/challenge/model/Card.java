package com.example.challenge.model;

import com.example.challenge.util.Brand;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Card {

    private Long number;

    private Brand brand;

    private CardHolder cardHolder;

    private LocalDate expirationDate;

    private List<Operation> operations;

    public boolean isValid() {
        return false;
    }


}
