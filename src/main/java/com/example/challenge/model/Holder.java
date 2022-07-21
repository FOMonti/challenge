package com.example.challenge.model;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "holder")
@Data
@SQLDelete(sql = "UPDATE holder SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Holder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "firstName must no be null")
    private String firstName;

    @NotNull(message = "lastName must no be null")
    private String lastName;

    private boolean deleted = Boolean.FALSE;

}
