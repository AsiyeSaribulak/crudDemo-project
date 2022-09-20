package com.etiya.proje3.controller;

import com.etiya.proje3.dto.ProductDto;
import com.etiya.proje3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping("/productSave")
    public ResponseEntity<ProductDto> save( @RequestBody ProductDto productDto){
        ProductDto add=productService.save(productDto);
        return ResponseEntity.ok(add);
    }

    @GetMapping("/productGetById")
    public ResponseEntity<ProductDto> productGetById(@NotNull @PathVariable("id") Long id){
        try{
            ProductDto productDto=productService.getById(id);
            return ResponseEntity.ok(productDto);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getproductCode/{productCode}")
    public ResponseEntity<ProductDto> getproductCode(@NotNull @PathVariable("productCode") Long productCode){
        try{
            ProductDto productDto=productService.getByProduceCode(productCode);
            return ResponseEntity.ok(productDto);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/productGetall")
    public ResponseEntity<List<ProductDto>> productGetall(){
        final List<ProductDto> listele=productService.getall();
        return ResponseEntity.ok(listele);
    }

    @GetMapping("/getproductName/{productName}")
    public ResponseEntity<List<ProductDto>> getproductName(@NotNull @PathVariable("productName") String productName){
        try{
            List<ProductDto> productDto=productService.getByName(productName);
            return ResponseEntity.ok(productDto);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity <Map<String, Boolean>> delete(@PathVariable("id") Long id){
        try {
            Map sil=productService.delete(id);
            return ResponseEntity.ok(sil);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/prouctUpdate/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable("id") Long id,@RequestBody ProductDto productDto){
        try {
           final ProductDto guncelle=productService.update(id,productDto);
            return ResponseEntity.ok(guncelle);
        }catch (Exception e){
            return new  ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



}
