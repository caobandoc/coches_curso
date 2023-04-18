package com.caoc.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Long codeCar;
    private Integer brandCarId;
    private String brand;
    private String reference;
    private Double price;
    private Integer modelYear;
    private String color;
    private Integer horsePower;
    private Integer numberDoors;
    private Integer cylinder;
    private String transmission;
    private String fuelType;
    private Integer numberSeat;
    private Integer traction;
    private String steering;
    private String category;
    private Integer quantity;
    private String imagePath;
}
