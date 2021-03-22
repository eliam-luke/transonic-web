package com.example.transonicweb.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.transonicweb.domain.product.Product;
import com.example.transonicweb.domain.product.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void WhenInvlidId_thenReturnNull() {
        Product found = productRepository.findById(-1l).orElse(null);
        assertThat(found).isNull();
    }

    @Test
    public void whenFindByIsbn_thenReturnProduct() {
        Product item = new Product();
        item.setAuthor("Author");
        item.setGenre("Genre");
        item.setIsbn("1234567890");
        item.setPublicationYear(2009);
        item.setPublisher("Publisher");
        item.setStatus(Boolean.TRUE);
        item.setStock(99);
        item.setTitle("Title");
        item.setUnitPrice(2000);
        entityManager.persistAndFlush(item);
        Optional<Product> found = productRepository.findById(item.getId());
        assertThat(found.get().getId()).isEqualTo(item.getId());
    }
}
