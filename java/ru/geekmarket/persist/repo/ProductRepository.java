package com.geekbrains.spring2.persist.repo;

import com.geekbrains.spring2.persist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("from Product p where name = :name")
    Product findOneByName(String name);
}
