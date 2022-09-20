package com.etiya.proje3.repository;

import com.etiya.proje3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(
            nativeQuery = true,
            value = "select * from product where product.productName=:productName"
    )
    List<Product> findByProductName(@Param("productName") String poductName);

    @Query(
            nativeQuery = true,
            value = "select * from product where product.productCode=:productCode"
    )
    Product findByProductCode(@Param("productCode") Long productCode);
}
