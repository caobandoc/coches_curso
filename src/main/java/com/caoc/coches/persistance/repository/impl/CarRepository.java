package com.caoc.coches.persistance.repository.impl;

import com.caoc.coches.domain.dto.CarDto;
import com.caoc.coches.domain.repository.ICarRepository;
import com.caoc.coches.persistance.entity.CarEntity;
import com.caoc.coches.persistance.mapper.ICarMapper;
import com.caoc.coches.persistance.repository.ICarCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository carCrudRepository;
    private final ICarMapper carMapper;
    @Override
    public List<CarDto> getAll() {
        return carMapper.toCarDtoList(carCrudRepository.findAll());
    }

    @Override
    public Optional<CarDto> getCarById(Long carId) {
        return carCrudRepository.findById(carId).map(carMapper::toCarDto);
    }

    @Override
    public List<CarDto> getCarsByBrandId(Integer brandId) {
        return carMapper.toCarDtoList(carCrudRepository.findAllByBrandCarId(brandId));
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return carMapper.toCarDtoList(carCrudRepository.findAllByPriceLessThanEqualOrderByPriceAsc(price));
    }

    @Override
    public CarDto save(CarDto car) {
        CarEntity carEntity = carMapper.toCarEntity(car);
        return carMapper.toCarDto(carCrudRepository.save(carEntity));
    }

    @Override
    public void delete(Long carId) {
        carCrudRepository.deleteById(carId);
    }
}
