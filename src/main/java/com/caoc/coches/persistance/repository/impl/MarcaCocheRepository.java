package com.caoc.coches.persistance.repository.impl;

import com.caoc.coches.domain.dto.MarcaCocheDto;
import com.caoc.coches.domain.repository.IMarcaCocheRepository;
import com.caoc.coches.persistance.entity.MarcaCocheEntity;
import com.caoc.coches.persistance.mapper.IMarcaCocheMapper;
import com.caoc.coches.persistance.repository.IMarcaCocheCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MarcaCocheRepository implements IMarcaCocheRepository {

    private final IMarcaCocheCrudRepository marcaCocheCrudRepository;
    private final IMarcaCocheMapper marcaCocheMapper;

    @Override
    public List<MarcaCocheDto> getAll() {
        return marcaCocheMapper.toMarcaCocheDtoList(marcaCocheCrudRepository.findAll());
    }

    @Override
    public Optional<MarcaCocheDto> getMarcaCocheById(int id) {
        return marcaCocheCrudRepository.findById(id).map(marcaCocheMapper::toMarcaCocheDto);
    }

    @Override
    public MarcaCocheDto save(MarcaCocheDto marcaCocheDto) {
        MarcaCocheEntity marcaCocheEntity = marcaCocheMapper.toMarcaCocheEntity(marcaCocheDto);
        return marcaCocheMapper.toMarcaCocheDto(marcaCocheCrudRepository.save(marcaCocheEntity));

    }

    @Override
    public void delete(Integer id) {
        marcaCocheCrudRepository.deleteById(id);
    }
}
