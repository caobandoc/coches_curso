package com.caoc.coches.persistance.mapper;

import com.caoc.coches.domain.dto.PurchaseRequestDto;
import com.caoc.coches.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity);

    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toPurchaseRequestDto(List<PurchaseEntity> purchaseEntity);

}
