package com.geekbrains.spring2.controller.admin;

import com.geekbrains.spring2.persist.model.Product;
import com.geekbrains.spring2.persist.repo.BrandRepository;
import com.geekbrains.spring2.service.CategoryService;
import com.geekbrains.spring2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final BrandRepository brandRepository;

    @Autowired
    public AdminProductController(ProductService productService, CategoryService categoryService, BrandRepository brandRepository) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/admin/product")
    public String adminProductsPage(Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products", productService.findAll());
        return "admin/product";
    }

    @GetMapping("/admin/product/{id}/edit")
    public String adminEditProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit");
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/product_form";
    }

    @GetMapping("/admin/product/{id}/delete")
    public String adminDeleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/create")
    public String adminCreateProduct(Model model) {
        model.addAttribute("create");
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/product_form";
    }

    @PostMapping("/admin/product")
    public String adminInsertProduct(@Valid Product product, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Products");
        if (bindingResult.hasErrors())
            return "admin/product_form";
        productService.save(product);
        return "redirect:/admin/product";
    }
}
