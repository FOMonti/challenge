package com.example.challenge.mapper;

import com.example.challenge.dto.OperationDto;
import com.example.challenge.dto.OperationDtoCreate;
import com.example.challenge.model.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationMapper {

    public Operation operationDtoCreate2Entity(OperationDtoCreate operationDtoCreate) {
        Operation operation = new Operation();
        operation.setConsumption(operationDtoCreate.getConsumption());
        return operation;
    }

    public OperationDto operationEntity2Dto(Operation operation) {
        OperationDto operationDto = new OperationDto();
        operationDto.setId(operation.getId());
        operationDto.setCreatedAt(operation.getCreatedAt());
        operationDto.setConsumption(operation.getConsumption());
        return operationDto;
    }

    public List<OperationDto> operationEntityList2DtoList(List<Operation> operations) {
        List<OperationDto> operationDtos = new ArrayList<>();
        for (Operation operation : operations)
            operationDtos.add(operationEntity2Dto(operation));
        return operationDtos;
    }
}
