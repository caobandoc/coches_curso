package com.caoc.coches.persistance.repository;

import com.caoc.coches.persistance.entity.MarcaCocheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaCocheCrudRepository extends JpaRepository<MarcaCocheEntity, Integer> {
}
