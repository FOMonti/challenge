package com.example.challenge.controller;

import com.example.challenge.dto.HolderDtoCreat;
import com.example.challenge.service.IHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/holders")
public class HolderController {

    private final IHolderService holderService;

    @Autowired
    public HolderController(IHolderService iHolderService) {
        this.holderService = iHolderService;
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody HolderDtoCreat holderDtoCreat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(holderService.save(holderDtoCreat));
    }

    @GetMapping
    public ResponseEntity<?> getByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(holderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByiD(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(holderService.getHolderWithCards(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        holderService.delete(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
