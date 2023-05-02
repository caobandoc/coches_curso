package com.caoc.coches.persistance.mapper;

import com.caoc.coches.domain.dto.BrandCarDto;
import com.caoc.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma objetos de MarchaCoche a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {


    /**
     * Convierte una entidad a un pojo de marca coche
     * @param marcaEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarDto toMarcaCocheDto(BrandCarEntity marcaEntity);


    /**
     * Convierte un pojo a una entidad de marca coche
     * @param marcaPojo Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    @Mapping(target = "carEntities", ignore = true)
    BrandCarEntity toMarcaCocheEntity(BrandCarDto marcaPojo);

    /**
     * Retorna una lista de marcas coche transformada a pojo de una lista de entidades
     * @param marcasCocheEntity Entidad a transformar
     * @return Lista transformada
     */
    List<BrandCarDto> toMarcasCocheDto(List<BrandCarEntity> marcasCocheEntity);
}
