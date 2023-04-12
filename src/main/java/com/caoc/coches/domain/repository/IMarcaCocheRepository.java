package com.caoc.coches.domain.repository;

import com.caoc.coches.domain.dto.MarcaCocheDto;

import java.util.List;
import java.util.Optional;

public interface IMarcaCocheRepository {

    List<MarcaCocheDto> getAll();

    Optional<MarcaCocheDto> getMarcaCocheById(int id);

    MarcaCocheDto save(MarcaCocheDto marcaCocheDto);

    void delete(Integer id);

}
