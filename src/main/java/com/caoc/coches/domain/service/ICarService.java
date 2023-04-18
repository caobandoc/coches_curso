package com.caoc.coches.domain.service;

import com.caoc.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarService {
    List<CarDto> getAll();
    Optional<CarDto> getCarById(Long id);
    List<CarDto> getCarsByBrandId(int brandId);
    List<CarDto> getCarsByPriceLessThan(double price);
    CarDto save(CarDto carDto);
    boolean delete(Long id);

    Optional<CarDto> update(CarDto carDto);
}
