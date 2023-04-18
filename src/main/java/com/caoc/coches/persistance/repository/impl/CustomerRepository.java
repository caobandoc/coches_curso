package com.caoc.coches.persistance.repository.impl;

import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.domain.repository.ICustomerRepository;
import com.caoc.coches.persistance.entity.CustomerEntity;
import com.caoc.coches.persistance.mapper.ICustomerMapper;
import com.caoc.coches.persistance.repository.ICustomerCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository customerCrudRepository;
    private final ICustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return customerMapper.toCustomerDtoList(customerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerByCarId(String carId) {
        return customerCrudRepository.findById(carId).map(customerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return customerCrudRepository.findByEmail(email).map(customerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(customer);
        return customerMapper.toCustomerDto(customerCrudRepository.save(customerEntity));
    }

    @Override
    public void delete(String carId) {
        customerCrudRepository.deleteById(carId);
    }
}
