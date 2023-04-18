package com.caoc.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "coches")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche")
    private Long codeCar;
    @Column(name = "marca_coche_id")
    private Integer brandCarId;
    @Column(name = "referencia")
    private String reference;
    @Column(name = "precio")
    private Double price;
    @Column(name = "anio_modelo")
    private Integer modelYear;
    @Column(name = "color")
    private String color;
    @Column(name = "numero_caballos_fuerza")
    private Integer horsePower;
    @Column(name = "cantidad_puertas")
    private Integer numberDoors;
    @Column(name = "cilindraje")
    private Integer cylinder;
    @Column(name = "transmision")
    private String transmission;
    @Column(name = "tipo_combustible")
    private String fuelType;
    @Column(name = "cantidad_asientos")
    private Integer numberSeat;
    @Column(name = "traccion")
    private Integer traction;
    @Column(name = "direccion")
    private String steering;
    @Column(name = "categoria")
    private String category;
    @Column(name = "cantidad")
    private Integer quantity;
    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private BrandCarEntity brandCarEntity;

    @OneToMany(mappedBy = "carEntity")
    private List<CarPurchaseEntity> carPurchaseEntity;

}
