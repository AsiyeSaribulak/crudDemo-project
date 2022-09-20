package com.etiya.proje3.dto;


import com.etiya.proje3.entity.Product;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String password;
    private String userType;
    private List<ProductDto> product;

}
