package com.example.challenge.dto;

import com.example.challenge.util.Brand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaDto {

    private Double brandNumber;
    private Brand brand;
    private Double consumption;

}
