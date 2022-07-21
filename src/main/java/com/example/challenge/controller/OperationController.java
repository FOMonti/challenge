package com.example.challenge.controller;

import com.example.challenge.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping()
public class OperationController {

    @Autowired
    private IOperationService iOperationService;

    @GetMapping
    public ResponseEntity<?> operationValid() {
        return null;
    }
}
