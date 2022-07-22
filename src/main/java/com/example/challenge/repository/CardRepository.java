package com.example.challenge.repository;

import com.example.challenge.model.Card;
import com.example.challenge.model.Holder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByNumber(Long number);

    List<Card> findByCardHolder(Holder holder);
}
