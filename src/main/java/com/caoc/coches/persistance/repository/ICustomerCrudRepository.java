package com.caoc.coches.persistance.repository;

import com.caoc.coches.persistance.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.email = ?1")
    Optional<CustomerEntity> findByEmail(String email);
}
