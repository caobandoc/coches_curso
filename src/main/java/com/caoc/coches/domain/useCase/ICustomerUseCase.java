package com.caoc.coches.domain.useCase;

import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicio de cliente
 */
public interface ICustomerUseCase {

    /**
     * Devuelve una lista con todos los cliente
     * @return Lista con clientes
     */
    List<CustomerDto> getAll();


    Optional<CustomerDto> getCustomerByCardId(String cardId);


    Optional<CustomerDto> getCustomerByEmail(String email);


    ResponseCustomerDto save(CustomerDto newCustomer);

    Optional<CustomerDto> update(CustomerDto modifyCustomer);


    boolean delete(String  cardId);
}
