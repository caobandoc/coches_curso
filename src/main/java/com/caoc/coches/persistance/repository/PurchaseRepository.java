package com.caoc.coches.persistance.repository;

import com.caoc.coches.domain.dto.PurchaseRequestDto;
import com.caoc.coches.domain.dto.PurchaseResponseDto;
import com.caoc.coches.domain.repository.IPurchaseRepository;
import com.caoc.coches.persistance.crud.IPurchaseCrudRepository;
import com.caoc.coches.persistance.mapper.IPurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository {

    private final IPurchaseCrudRepository iPurchaseCrudRepository;

    private final IPurchaseMapper iPurchaseMapper;

    @Override
    public List<PurchaseResponseDto> getAll() {

       // List<PurchaseEntity> listPurchasesEntity = iPurchaseCrudRepository.findAll();

       // for (PurchaseEntity purchaseEntity: listPurchasesEntity) {
        //    List<>purchaseEntity.getCarsPurchase();
        //}
       return null;
    }

    @Override
    public List<PurchaseResponseDto> getByIdCustomer(String idCustomer) {
        return null;
    }

    @Override
    public PurchaseResponseDto save(PurchaseRequestDto purchaseRequestDto) {
        return null;
    }
}
