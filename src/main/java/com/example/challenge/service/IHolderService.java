package com.example.challenge.service;

import com.example.challenge.dto.HolderCompleteDto;
import com.example.challenge.dto.HolderDto;
import com.example.challenge.dto.HolderDtoCreat;

public interface IHolderService {

    HolderDto save(HolderDtoCreat holderDtoCreat);

    HolderCompleteDto getHolderWithCards(Long id);

    void delete(Long id);
}
