package com.konovalov.toysrestapp.repository;

import com.konovalov.toysrestapp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
