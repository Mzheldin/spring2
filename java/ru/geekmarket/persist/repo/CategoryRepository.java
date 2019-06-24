package com.geekbrains.spring2.persist.repo;

import com.geekbrains.spring2.persist.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("from Category c where name = :name")
    Category findOneByName(String name);
}
