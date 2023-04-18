package com.caoc.coches.domain.service.impl;

import com.caoc.coches.domain.dto.BrandCarDto;
import com.caoc.coches.domain.repository.IBrandCarRepository;
import com.caoc.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandCarService implements IBrandCarService {

    private final IBrandCarRepository marcaCocheRepository;
    @Override
    public List<BrandCarDto> getAll() {
        return marcaCocheRepository.getAll();
    }

    @Override
    public Optional<BrandCarDto> getMarcaCocheById(int id) {
        return marcaCocheRepository.getMarcaCocheById(id);
    }

    @Override
    public BrandCarDto save(BrandCarDto brandCarDto) {
        return marcaCocheRepository.save(brandCarDto);
    }

    @Override
    public boolean delete(Integer id) {
        if (marcaCocheRepository.getMarcaCocheById(id).isEmpty()) {
            return false;
        }
        marcaCocheRepository.delete(id);
        return true;
    }

    @Override
    public Optional<BrandCarDto> update(BrandCarDto brandCarDto) {
        if (marcaCocheRepository.getMarcaCocheById(brandCarDto.getId()).isPresent()) {
            return Optional.of(marcaCocheRepository.save(brandCarDto));
        } else {
            return Optional.empty();
        }
    }
}
