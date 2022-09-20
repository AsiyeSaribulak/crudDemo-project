package com.etiya.proje3.mapper;

import com.etiya.proje3.dto.ProductDto;
import com.etiya.proje3.entity.Product;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.ACCESSOR_ONLY
       )
public interface ProductMapper {

    Product productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Product product);
    void updateProductFromDto(ProductDto newProductDto, @MappingTarget Product oldProduct);

}
