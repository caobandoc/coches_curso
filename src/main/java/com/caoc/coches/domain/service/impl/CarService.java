package com.caoc.coches.domain.service.impl;

import com.caoc.coches.domain.dto.CarDto;
import com.caoc.coches.domain.repository.ICarRepository;
import com.caoc.coches.domain.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final ICarRepository carRepository;

    @Override
    public List<CarDto> getAll() {
        return carRepository.getAll();
    }

    @Override
    public Optional<CarDto> getCarById(Long id) {
        return carRepository.getCarById(id);
    }

    @Override
    public List<CarDto> getCarsByBrandId(int brandId) {
        return carRepository.getCarsByBrandId(brandId);
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(double price) {
        return carRepository.getCarsByPriceLessThan(price);
    }

    @Override
    public CarDto save(CarDto carDto) {
        return carRepository.save(carDto);
    }

    @Override
    public boolean delete(Long id) {
        if (carRepository.getCarById(id).isEmpty()) {
            return false;
        }
        carRepository.delete(id);
        return true;
    }

    @Override
    public Optional<CarDto> update(CarDto carDto) {
        if (carRepository.getCarById(carDto.getCodeCar()).isPresent()) {
            return Optional.of(carRepository.save(carDto));
        } else {
            return Optional.empty();
        }
    }
}
