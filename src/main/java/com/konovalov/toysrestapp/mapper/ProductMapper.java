package com.konovalov.toysrestapp.mapper;

import com.konovalov.toysrestapp.dto.ProductRequest;
import com.konovalov.toysrestapp.dto.ProductResponse;
import com.konovalov.toysrestapp.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    Product toProduct(ProductRequest productRequest);

    ProductResponse fromProductToResponse(Product product);

    void updateProduct(@MappingTarget Product product, ProductRequest productRequest);


    List<ProductResponse> fromProductListToProductReponseList(List<Product> products);

}
