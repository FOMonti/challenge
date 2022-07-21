package com.example.challenge.service.implementation;

import com.example.challenge.dto.HolderDto;
import com.example.challenge.dto.HolderDtoCreat;
import com.example.challenge.mapper.HolderMapper;
import com.example.challenge.model.Holder;
import com.example.challenge.repository.HolderRepository;
import com.example.challenge.service.IHolderService;
import org.springframework.stereotype.Service;

@Service
public class HolderService implements IHolderService {

    private final HolderRepository holderRepository;
    private final HolderMapper holderMapper;

    public HolderService(HolderRepository holderRepository, HolderMapper holderMapper) {
        this.holderMapper = holderMapper;
        this.holderRepository = holderRepository;
    }

    @Override
    public HolderDto save(HolderDtoCreat holderDtoCreat) {
        Holder holder = holderMapper.holderCreatDto2Entity(holderDtoCreat);
        holderRepository.save(holder);
        return holderMapper.holderEntity2Dto(holder);
    }
}
