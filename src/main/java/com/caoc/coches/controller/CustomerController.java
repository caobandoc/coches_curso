package com.caoc.coches.controller;

import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.domain.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId) {
        return ResponseEntity.of(customerService.getCustomerByCardId(cardId));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(customerService.getCustomerByEmail(email));
    }

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.save(customerDto));
    }

    @PutMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.of(customerService.update(customerDto));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId) {
        return new ResponseEntity<>(customerService.delete(cardId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
