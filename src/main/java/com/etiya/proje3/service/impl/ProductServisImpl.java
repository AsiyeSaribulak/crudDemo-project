package com.etiya.proje3.service.impl;

import com.etiya.proje3.dto.ProductDto;
import com.etiya.proje3.entity.Product;
import com.etiya.proje3.mapper.ProductMapper;
import com.etiya.proje3.repository.ProductRepository;
import com.etiya.proje3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductServisImpl implements ProductService {


    private final ProductRepository productRepository;

    private ProductMapper productMapper= Mappers.getMapper(ProductMapper.class);

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product =productRepository.save(productMapper.productDtoToProduct(productDto));
        return productMapper.productToProductDto(product);
    }

    @Override
    public ProductDto getById(Long id) {
       Optional<Product> product=productRepository.findById(id);
        return product.map(this.productMapper::productToProductDto).orElseThrow(()-> new RuntimeException("ürün bulunamadı::"+id));
    }

    @Override
    public List<ProductDto> getByName(String productName) {
       return productRepository.findByProductName(productName)
               .stream()
               .map(product -> productMapper.productToProductDto(product))
               .collect(Collectors.toList());


    }

    @Override
    public ProductDto getByProduceCode(@NotNull Long productCode) {
        Optional<Product> product= Optional.ofNullable(productRepository.findByProductCode(productCode));
        return product.map(this.productMapper::productToProductDto)
                .orElseThrow(()-> new RuntimeException("ürün bulunamadı::"+productCode));
    }

    @Override
    public List<ProductDto> getall() {
        return productRepository.findAll()
                .stream()
                .map(product->productMapper.productToProductDto(product))
                .collect(Collectors.toList());

    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Product product=productRepository.findById(id).orElseThrow(()-> new RuntimeException("ürün bulunamadı::"+id));
        productRepository.delete(product);
        Map<String, Boolean> sil=new HashMap<>();
        sil.put("silindi",Boolean.TRUE);
        return sil;
    }

    @Override
    public ProductDto update(Long id, ProductDto newProductDto) {
         Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("ürün bulunamadı::"+ id));
         productMapper.updateProductFromDto(newProductDto,product);
         productRepository.save(product);
         return productMapper.productToProductDto(product);
    }
}
