package com.konovalov.toysrestapp.dto;

import java.math.BigDecimal;

public record ProductRequest
        (String id,
         String name,
         String description,
         BigDecimal price) {
}
