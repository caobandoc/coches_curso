package com.caoc.coches.persistance.crud;

import com.caoc.coches.persistance.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseCrudRepository extends JpaRepository<PurchaseEntity, Integer> {

}
