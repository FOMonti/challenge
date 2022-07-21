package com.example.challenge.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Operation {

    private Timestamp timestamp;

    private Double consumption;
}
