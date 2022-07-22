package com.example.challenge.service.implementation;

import com.example.challenge.dto.HolderDto;
import com.example.challenge.dto.HolderDtoCreat;
import com.example.challenge.mapper.HolderMapper;
import com.example.challenge.model.Holder;
import com.example.challenge.repository.HolderRepository;
import com.example.challenge.service.IHolderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    @Override
    public void delete(Long id) {
        Optional<Holder> holder = holderRepository.findById(id);
        holder.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        holderRepository.delete(holder.get());
    }
}
