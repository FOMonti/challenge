package com.example.challenge.service.implementation;

import com.example.challenge.dto.HolderCompleteDto;
import com.example.challenge.dto.HolderDto;
import com.example.challenge.dto.HolderDtoCreat;
import com.example.challenge.mapper.CardMapper;
import com.example.challenge.mapper.HolderMapper;
import com.example.challenge.model.Holder;
import com.example.challenge.repository.CardRepository;
import com.example.challenge.repository.HolderRepository;
import com.example.challenge.service.IHolderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HolderService implements IHolderService {

    private final HolderRepository holderRepository;
    private final CardRepository cardRepository;
    private final HolderMapper holderMapper;
    private final CardMapper cardMapper;

    public HolderService(HolderRepository holderRepository, HolderMapper holderMapper,
                         CardMapper cardMapper, CardRepository cardRepository) {
        this.holderMapper = holderMapper;
        this.holderRepository = holderRepository;
        this.cardMapper = cardMapper;
        this.cardRepository = cardRepository;
    }

    @Override
    public HolderDto save(HolderDtoCreat holderDtoCreat) {
        Holder holder = holderMapper.holderCreatDto2Entity(holderDtoCreat);
        holderRepository.save(holder);
        return holderMapper.holderEntity2Dto(holder);
    }

    @Override
    public HolderCompleteDto getHolderWithCards(Long id) {
        Optional<Holder> holder = holderRepository.findById(id);
        holder.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        HolderCompleteDto holderCompleteDto = holderMapper.holderEntityComplete(holder.get());
        holderCompleteDto.setCardDtos(cardMapper.cardListEntity2DtoList(cardRepository.findByCardHolder(holder.get())));
        return holderCompleteDto;
    }


    @Override
    public void delete(Long id) {
        Optional<Holder> holder = holderRepository.findById(id);
        holder.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        holderRepository.delete(holder.get());
    }
}
