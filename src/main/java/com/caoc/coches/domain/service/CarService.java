package com.caoc.coches.domain.service;

import com.caoc.coches.domain.dto.CarDto;
import com.caoc.coches.domain.repository.ICarRepository;
import com.caoc.coches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService implements ICarUseCase {

    private final ICarRepository iCarRepository;

    @Override
    public List<CarDto> getAll() {

        var listaRoles = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
/*
        if (listaRoles.stream().noneMatch(rol -> String.valueOf(rol).equals("Customer"))) {
            throw new UnauthorizedException();
        }

        if (listaRoles.stream().anyMatch(rol -> String.valueOf(rol).equals("Junior")) ) {
            //llama al metodo del junior
        }
        if (listaRoles.stream().anyMatch(rol -> String.valueOf(rol).equals("Senior")) ) {
            //llama al metodo del senior
        }*/

        return iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return iCarRepository.getByIdBrandCar(idBrandCar);
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarRepository.getCarsByPriceLessThan(price);
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
        return iCarRepository.getCar(idCar);
    }

    @Override
    public CarDto save(CarDto newCar) {
        return iCarRepository.save(newCar);
    }

    @Override
    public boolean delete(Integer idCar) {

        if (iCarRepository.getCar(idCar).isEmpty()) {
            return false;
        }

        iCarRepository.delete(idCar);
        return true;
    }
}
