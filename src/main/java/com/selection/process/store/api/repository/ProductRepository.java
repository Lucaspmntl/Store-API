package com.selection.process.store.api.repository;

import com.selection.process.store.api.entity.Product;
import com.selection.process.store.api.projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT WHERE LOWER(NAME) LIKE CONCAT('%', :name, '%') ")
    List<ProductProjection> searchByPartialName(String name);
}
