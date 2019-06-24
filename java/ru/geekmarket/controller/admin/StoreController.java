package com.geekbrains.spring2.controller.admin;

import com.geekbrains.spring2.service.CategoryService;
import com.geekbrains.spring2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public StoreController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/store")
    public String showStore(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "store";
    }


}
