package com.example.challenge.repository;

import com.example.challenge.model.Card;
import com.example.challenge.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> getOperationByCard(Card card);
}
