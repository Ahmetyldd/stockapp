package com.stockapp.mapper;

import com.stockapp.domain.Attribute;
import com.stockapp.domain.TYProduct;
import com.stockapp.dto.product.ProductRequest;
import com.stockapp.dto.product.ProductResponse;
import com.stockapp.dto.trendyol.AttributeDto;
import com.stockapp.dto.trendyol.TYProductDto;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );
    ProductResponse entityToDto(TYProduct entity);
    TYProductDto entityToTYDto(TYProduct entity);
    TYProduct toEntity(ProductRequest request);


    @Mapping(target = "tyProduct", ignore = true)
    Attribute toEntity(AttributeDto s);

}
