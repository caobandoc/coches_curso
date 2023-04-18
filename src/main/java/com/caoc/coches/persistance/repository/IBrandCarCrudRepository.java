package com.caoc.coches.persistance.repository;

import com.caoc.coches.persistance.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Integer> {
}
