package com.geekbrains.spring2.persist.repo;

import com.geekbrains.spring2.persist.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
