package com.konovalov.toysrestapp.service;

import com.konovalov.toysrestapp.controller.exception.ProductNotFoundException;
import com.konovalov.toysrestapp.dto.ProductRequest;
import com.konovalov.toysrestapp.dto.ProductResponse;
import com.konovalov.toysrestapp.mapper.ProductMapper;
import com.konovalov.toysrestapp.model.Product;
import com.konovalov.toysrestapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void createProduct(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        productRepository.save(product);
        log.info("Product was saved with id: " + product.getId());
    }

    public ProductResponse getProductById(Long id) {
        Optional<Product> maybeProduct = productRepository.findById(String.valueOf(id));
        Product product = maybeProduct
                .orElseThrow(() -> new ProductNotFoundException("Product with this id: " + id + " wasn`t found"));
        log.info("Product was got with id: " + id);

        return productMapper.fromProductToResponse(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return productMapper.fromProductListToProductReponseList(products);
    }

    public void updateProduct(Long id, ProductRequest productRequest){
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        Product product = optionalProduct
                .orElseThrow(() -> new ProductNotFoundException("Product with this id: " + id + " wasn`t found"));

        productMapper.updateProduct(product, productRequest);
        productRepository.save(product);
        log.info(String.format("Product with id %s was updated", product.getId()));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(String.valueOf(id));
    }
}
