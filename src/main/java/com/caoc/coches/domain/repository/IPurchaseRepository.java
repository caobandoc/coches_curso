package com.caoc.coches.domain.repository;

import com.caoc.coches.domain.dto.PurchaseRequestDto;
import com.caoc.coches.domain.dto.PurchaseResponseDto;

import java.util.List;

public interface IPurchaseRepository {

    List<PurchaseResponseDto> getAll();

    List<PurchaseResponseDto> getByIdCustomer(String idCustomer);

    PurchaseResponseDto save(PurchaseRequestDto purchaseRequestDto);
}
