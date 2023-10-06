package com.konovalov.toysrestapp.mapper;

import com.konovalov.toysrestapp.dto.ProductRequest;
import com.konovalov.toysrestapp.dto.ProductResponse;
import com.konovalov.toysrestapp.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {


    Product toProduct(ProductRequest productRequest);

    ProductResponse fromProductToResponse(Product product);


    List<ProductResponse> fromProductListToProductReponseList(List<Product> products);

}
