package com.geekbrains.spring2.service;

import com.geekbrains.spring2.persist.model.Category;
import com.geekbrains.spring2.persist.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category findByCategoryName(String categoryName) {
        return categoryRepository.findOneByName(categoryName);
    }

    @Override
    public boolean save(Category category) {
        if (category.getName() != null){
            if (category.getId() == null) category.setId(0L);
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (categoryRepository.findById(id).isPresent()){
            categoryRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
