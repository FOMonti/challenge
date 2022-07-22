package com.example.challenge.controller;

import com.example.challenge.dto.OperationDto;
import com.example.challenge.dto.OperationDtoCreate;
import com.example.challenge.service.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private IOperationService operationService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody OperationDtoCreate operationDtoCreate) {
        return ResponseEntity.status(HttpStatus.CREATED).body(operationService.save(operationDtoCreate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        operationService.delete(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(operationService.getAll());
    }

    @GetMapping()
    public ResponseEntity<?> findOperationsByCard(@RequestParam(name = "Card-Number") Long cardNumber) {
        List<OperationDto> operationDtos = operationService.getOperationsBy(cardNumber);
        return ResponseEntity.ok().body(!operationDtos.isEmpty() ? operationDtos : "a");
    }
}
