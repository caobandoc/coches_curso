package com.caoc.coches.persistance.mapper;

import com.caoc.coches.domain.dto.CustomerDto;
import com.caoc.coches.persistance.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    @Mapping(target = "authorities", ignore = true)
    CustomerDto toCustomerDto(CustomerEntity clienteEntity);
    @Mapping(target = "purchaseEntityList", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto clienteDto);
    List<CustomerDto> toCustomerDtoList(List<CustomerEntity> clienteEntityList);

}
