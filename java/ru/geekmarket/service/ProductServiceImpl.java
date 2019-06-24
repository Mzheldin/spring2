package com.geekbrains.spring2.service;

import com.geekbrains.spring2.persist.model.Product;
import com.geekbrains.spring2.persist.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Product findByProductName(String productName) {
        return productRepository.findOneByName(productName);
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        if (product.getCategories() != null && product.getName() != null){
            if (product.getId() == null) product.setId(0L);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public boolean deleteProduct(Long id) {
        if (productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
