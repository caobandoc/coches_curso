package com.caoc.coches.domain.service.impl;

import com.caoc.coches.domain.dto.MarcaCocheDto;
import com.caoc.coches.domain.repository.IMarcaCocheRepository;
import com.caoc.coches.domain.service.IMarcaCocheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaCocheService implements IMarcaCocheService {

    private final IMarcaCocheRepository marcaCocheRepository;
    @Override
    public List<MarcaCocheDto> getAll() {
        return marcaCocheRepository.getAll();
    }

    @Override
    public Optional<MarcaCocheDto> getMarcaCocheById(int id) {
        return marcaCocheRepository.getMarcaCocheById(id);
    }

    @Override
    public MarcaCocheDto save(MarcaCocheDto marcaCocheDto) {
        return marcaCocheRepository.save(marcaCocheDto);
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
    public Optional<MarcaCocheDto> update(MarcaCocheDto marcaCocheDto) {
        if (marcaCocheRepository.getMarcaCocheById(marcaCocheDto.getId()).isPresent()) {
            return Optional.of(marcaCocheRepository.save(marcaCocheDto));
        } else {
            return Optional.empty();
        }
    }
}
