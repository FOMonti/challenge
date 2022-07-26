package com.example.challenge.mapper;

import com.example.challenge.dto.HolderCompleteDto;
import com.example.challenge.dto.HolderDto;
import com.example.challenge.dto.HolderDtoCreat;
import com.example.challenge.model.Holder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HolderMapper {

    public Holder holderCreatDto2Entity(HolderDtoCreat holderDtoCreat) {
        Holder holder = new Holder();
        holder.setFirstName(holderDtoCreat.getFirstName());
        holder.setLastName(holderDtoCreat.getLastName());
        return holder;
    }

    public HolderDto holderEntity2Dto(Holder holder) {
        HolderDto holderDto = new HolderDto();
        holderDto.setId(holder.getId());
        holderDto.setFirstName(holder.getFirstName());
        holderDto.setLastName(holder.getLastName());
        return holderDto;
    }

    public HolderCompleteDto holderEntityComplete(Holder holder) {
        HolderCompleteDto holderDto = new HolderCompleteDto();
        holderDto.setId(holder.getId());
        holderDto.setFirstName(holder.getFirstName());
        holderDto.setLastName(holder.getLastName());
        return holderDto;
    }

    public List<HolderDto> holderEntityList2Dto(List<Holder> holders) {
        List<HolderDto> holderDtos = new ArrayList<>();
        for (Holder holder : holders)
            holderDtos.add(holderEntity2Dto(holder));
        return holderDtos;
    }
}
