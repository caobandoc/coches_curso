package com.caoc.coches.persistance.mapper;

import com.caoc.coches.domain.pojo.MarcaCochePojo;
import com.caoc.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaCocheEntity);
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaCochePojo);

    List<MarcaCochePojo> toMarcaCochePojoList(List<MarcaCocheEntity> marcaCocheEntityList);
}
