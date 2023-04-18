package com.caoc.coches.domain.service;

import com.caoc.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<CustomerDto> getAll();
    Optional<CustomerDto> getCustomerByCardId(String cardId);
    Optional<CustomerDto> getCustomerByEmail(String email);
    CustomerDto save(CustomerDto customerDto);
    boolean delete(String cardId);
    Optional<CustomerDto> update(CustomerDto customerDto);

}
