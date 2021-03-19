package com.example.transonicweb.domain.product;

import java.util.Optional;

public interface ProductCustomRepository<T, S> {
    Optional<T> findByIsbn(String isbn);
}
