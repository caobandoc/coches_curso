package com.caoc.coches.domain.service.impl;

import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.domain.repository.ICustomerRepository;
import com.caoc.coches.domain.service.ICustomerService;
import com.caoc.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerByCardId(String cardId) {
        return customerRepository.getCustomerByCarId(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        // validar email regex
        if (!customerDto.getEmail().matches("^(?=.{1,254}$)[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new EmailValidationException();
        }
        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        customerDto.setActive(1);
        return customerRepository.save(customerDto);
    }

    @Override
    public boolean delete(String cardId) {
        if (customerRepository.getCustomerByCarId(cardId).isEmpty()) {
            return false;
        }
        customerRepository.delete(cardId);
        return true;
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto customerDto) {
        if (customerRepository.getCustomerByCarId(customerDto.getCardId()).isPresent()) {
            return Optional.of(customerRepository.save(customerDto));
        } else {
            return Optional.empty();
        }
    }
}
