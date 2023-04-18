package com.caoc.coches.domain.repository;

import com.caoc.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    List<CustomerDto> getAll();
    Optional<CustomerDto> getCustomerByCarId(String carId);
    Optional<CustomerDto> getCustomerByEmail(String email);
    CustomerDto save(CustomerDto customer);
    void delete(String carId);
}
