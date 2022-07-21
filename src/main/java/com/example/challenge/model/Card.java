package com.example.challenge.model;

import com.example.challenge.util.Brand;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "card")
@Data
@SQLDelete(sql = "UPDATE card SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotNull(message = "number must no be null")
    private Long number;

    @NotNull(message = "brand must no be null")
    private Brand brand;

    @NotNull(message = "Card Holder must not be null.")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "holder_id", nullable = false)
    private Holder cardHolder;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private boolean deleted = Boolean.FALSE;

    public boolean isValid() {
        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "\nCard Number: " + number +
                "\nBrand: " +
                "}";
    }

}
