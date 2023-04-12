package com.caoc.coches.domain.service;

import com.caoc.coches.domain.dto.MarcaCocheDto;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheService {

    List<MarcaCocheDto> getAll();

    Optional<MarcaCocheDto> getMarcaCocheById(int id);

    MarcaCocheDto save(MarcaCocheDto marcaCocheDto);

    boolean delete(Integer id);

    Optional<MarcaCocheDto> update(MarcaCocheDto marcaCocheDto);
}
