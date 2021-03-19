package com.example.transonicweb.domain.order;

import java.util.Optional;

public interface OrderCustomRepository<T, S> {
    Optional<T> findByIsbn(String isbn);
}
