package com.caoc.coches.controller;

import com.caoc.coches.domain.dto.CarDto;
import com.caoc.coches.domain.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        return ResponseEntity.of(carService.getCarById(id));
    }

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<CarDto>> getCarsByBrandId(@PathVariable int brandId) {
        return ResponseEntity.ok(carService.getCarsByBrandId(brandId));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<CarDto>> getCarsByPriceLessThan(@PathVariable double price) {
        return ResponseEntity.ok(carService.getCarsByPriceLessThan(price));
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDto) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(carDto));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<CarDto> update(@RequestBody CarDto carDto) {
        return ResponseEntity.of(carService.update(carDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(carService.delete(id) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


}
