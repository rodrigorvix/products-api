package com.letscode.productsapi.controller;

import com.letscode.productsapi.domain.ProductEntity;
import com.letscode.productsapi.dto.ProductDto;
import com.letscode.productsapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/products")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductEntity> getProducts() {

        return this.productService.getProducts();

    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {

        return this.productService.getProductById(id);

    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity createProduct (@RequestBody ProductEntity product){

        return this.productService.createProduct(product);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {

        this.productService.deleteProduct(id);

    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody ProductEntity product, @PathVariable Long id) {

        this.productService.updateProduct(product, id);

    }
}
