package com.caoc.coches.domain.repository;

import com.caoc.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {

    List<CarDto> getAll();
    Optional<CarDto> getCarById(Long carId);
    List<CarDto> getCarsByBrandId(Integer brandId);
    List<CarDto> getCarsByPriceLessThan(Double price);
    CarDto save(CarDto car);
    void delete(Long carId);
}
