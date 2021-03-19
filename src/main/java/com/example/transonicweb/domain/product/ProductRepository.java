package com.example.transonicweb.domain.product;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called productRepository
// CRUD refers Create, Read, Update, Delete

public interface ProductRepository extends CrudRepository<Product, Long>,
    ProductCustomRepository<Product, String> {
    Optional<Product> findByIsbn(String isbn);
}
