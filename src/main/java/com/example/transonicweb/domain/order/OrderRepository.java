package com.example.transonicweb.domain.order;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called productRepository
// CRUD refers Create, Read, Update, Delete

public interface OrderRepository extends CrudRepository<Order, Long>,
    OrderCustomRepository<Order, String> {
    Optional<Order> findByIsbn(String isbn);
}
