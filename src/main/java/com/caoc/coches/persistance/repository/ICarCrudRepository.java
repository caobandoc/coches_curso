package com.caoc.coches.persistance.repository;

import com.caoc.coches.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity, Long> {

    List<CarEntity> findAllByBrandCarId(Integer brandCarId);

    List<CarEntity> findAllByPriceLessThanEqualOrderByPriceAsc(Double price);
}
