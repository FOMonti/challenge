package com.example.challenge.service.implementation;

import com.example.challenge.model.Card;
import com.example.challenge.service.IOperationService;
import org.springframework.stereotype.Service;

@Service
public class OperationService implements IOperationService {
    @Override
    public double getRate(Card card) {
        return 0;
    }
}
