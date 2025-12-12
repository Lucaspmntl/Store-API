package com.selection.process.store.api.repository;

import com.selection.process.store.api.entity.Product;
import com.selection.process.store.api.projection.ProductProjection;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    public EntityManager entityManager;

    @Autowired
    public ProductRepository productRepository;

    @Test
    @DisplayName("searchByPartialName: Deve retornar uma lista contendo todos os produtos com o determinado nome")
    void shouldReturnListOfProductsWithPartialName() {
        String partialName = "teste";

        Product product1 = new Product();
        product1.setName("Monitor 27 Polegadas FHD Teste");
        entityManager.persist(product1);

        Product product2 = new Product();
        product2.setName("Monitor 25 Polegadas QUADHD teste");
        entityManager.persist(product2);

        entityManager.flush();
        entityManager.clear();

        List<ProductProjection> response = productRepository.searchByPartialName(partialName);

        Assertions.assertThat(response)
                .hasSize(2)
                .extracting("name")
                .contains(product1.getName(), product2.getName());
    }

    @Test
    @DisplayName("searchByPartialName: Deve retornar empty caso não haja produtos com o determinado nome")
    void shouldReturnEmptyIfProductDoesNotExist() {
        String partialName = "teste";

        List<ProductProjection> response = productRepository.searchByPartialName(partialName);

        Assertions.assertThat(response).isEmpty();
    }
}