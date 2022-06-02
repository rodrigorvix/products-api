package com.letscode.productsapi.services;

import com.letscode.productsapi.domain.ProductEntity;
import com.letscode.productsapi.dto.ProductDto;
import com.letscode.productsapi.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public List<ProductEntity> getProducts() {
        List<ProductEntity> products = this.productRepository.findAll();

        return products;
    }

    public ProductEntity createProduct(ProductEntity product) {
        product.setCreatedAt(ZonedDateTime.now());
        product.setUpdatedAt(ZonedDateTime.now());

        return  this.productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        this.productRepository.findById(id)
                .map( productExists -> {
                    this.productRepository.delete(productExists);
                    return productExists;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public void updateProduct(ProductEntity product, Long id) {
        this.productRepository
                .findById(id)
                .map(productExists -> {
                    product.setId(productExists.getId());
                    product.setCreatedAt(productExists.getCreatedAt());
                    product.setUpdatedAt(ZonedDateTime.now());
                    this.productRepository.save(product);
                    return productExists;
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public ProductDto getProductById(Long id) {
        Optional<ProductEntity> productExists = this.productRepository.findById(id);

        if(productExists.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(productExists.get().getId());
        productDto.setName(productExists.get().getName());
        productDto.setDescription(productExists.get().getDescription());
        productDto.setPrice(productExists.get().getPrice());

        return productDto;
    }
}
