package com.caoc.coches.domain.repository;

import com.caoc.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    List<BrandCarDto> getAll();

    Optional<BrandCarDto> getMarcaCocheById(int id);

    BrandCarDto save(BrandCarDto brandCarDto);

    void delete(Integer id);

}
