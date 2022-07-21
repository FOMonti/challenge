package com.example.challenge.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "holder")
@Data
public class Holder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "firstName must no be null")
    private String firstName;

    @NotNull(message = "lastName must no be null")
    private String lastName;

}
