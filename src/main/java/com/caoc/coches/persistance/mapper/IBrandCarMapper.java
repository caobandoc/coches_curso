package com.caoc.coches.persistance.mapper;

import com.caoc.coches.domain.dto.BrandCarDto;
import com.caoc.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarDto toMarcaCocheDto(BrandCarEntity brandCarEntity);
    @InheritInverseConfiguration
    @Mapping(target = "carEntity", ignore = true)
    BrandCarEntity toMarcaCocheEntity(BrandCarDto brandCarDto);

    List<BrandCarDto> toMarcaCocheDtoList(List<BrandCarEntity> brandCarEntityList);
}
