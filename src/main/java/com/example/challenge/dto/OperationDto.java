package com.example.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class OperationDto {

    private Long id;

    private Timestamp createdAt;

    private Double consumption;
}
