package com.etiya.proje3.service;

import com.etiya.proje3.dto.ProductDto;


import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductDto save(ProductDto productDto);
    ProductDto getById(Long id);
    List<ProductDto> getByName(String productName);
    ProductDto getByProduceCode(Long productCode);
    List<ProductDto> getall();
    Map<String,Boolean> delete(Long id);
    ProductDto update(Long id,ProductDto productDto);

}
