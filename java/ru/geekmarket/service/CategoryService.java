package com.geekbrains.spring2.service;

import com.geekbrains.spring2.persist.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    Category findByCategoryName(String categoryName);

    boolean save(Category product);

    List<Category> findAll();

    boolean deleteCategory(Long id);
}
