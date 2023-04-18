package com.caoc.coches.persistance.repository.impl;

import com.caoc.coches.domain.dto.BrandCarDto;
import com.caoc.coches.domain.repository.IBrandCarRepository;
import com.caoc.coches.persistance.entity.BrandCarEntity;
import com.caoc.coches.persistance.mapper.IBrandCarMapper;
import com.caoc.coches.persistance.repository.IBrandCarCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandCarRepository implements IBrandCarRepository {

    private final IBrandCarCrudRepository marcaCocheCrudRepository;
    private final IBrandCarMapper marcaCocheMapper;

    @Override
    public List<BrandCarDto> getAll() {
        return marcaCocheMapper.toMarcaCocheDtoList(marcaCocheCrudRepository.findAll());
    }

    @Override
    public Optional<BrandCarDto> getMarcaCocheById(int id) {
        return marcaCocheCrudRepository.findById(id).map(marcaCocheMapper::toMarcaCocheDto);
    }

    @Override
    public BrandCarDto save(BrandCarDto brandCarDto) {
        BrandCarEntity brandCarEntity = marcaCocheMapper.toMarcaCocheEntity(brandCarDto);
        return marcaCocheMapper.toMarcaCocheDto(marcaCocheCrudRepository.save(brandCarEntity));

    }

    @Override
    public void delete(Integer id) {
        marcaCocheCrudRepository.deleteById(id);
    }
}
