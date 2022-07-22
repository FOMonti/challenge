package com.example.challenge.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "operation")
@Data
@SQLDelete(sql = "UPDATE operation SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @NotNull(message = "consumption must no be null")
    private Double consumption;

    @Column(name = "consumption_date")
    private LocalDate consuptionDay;

    @NotNull(message = "Card must not be null.")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    private boolean deleted = Boolean.FALSE;
}
