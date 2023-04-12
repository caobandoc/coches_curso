package com.caoc.coches.persistance.mapper;

import com.caoc.coches.domain.dto.MarcaCocheDto;
import com.caoc.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCocheDto toMarcaCocheDto(MarcaCocheEntity marcaCocheEntity);
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCocheDto marcaCocheDto);

    List<MarcaCocheDto> toMarcaCocheDtoList(List<MarcaCocheEntity> marcaCocheEntityList);
}
