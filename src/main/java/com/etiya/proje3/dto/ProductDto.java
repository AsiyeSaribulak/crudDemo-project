package com.etiya.proje3.dto;

import com.etiya.proje3.entity.Users;
import lombok.Data;

import javax.persistence.Column;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private int productCode;
    private int stock;
    private String brand;

}
