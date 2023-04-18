package com.caoc.coches.domain.service;

import com.caoc.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    List<BrandCarDto> getAll();

    Optional<BrandCarDto> getMarcaCocheById(int id);

    BrandCarDto save(BrandCarDto brandCarDto);

    boolean delete(Integer id);

    Optional<BrandCarDto> update(BrandCarDto brandCarDto);
}
