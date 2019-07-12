package com.geekbrains.spring2.controller.admin;

import com.geekbrains.spring2.persist.model.Category;
import com.geekbrains.spring2.service.CategoryService;
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
@RequestMapping("/admin/category")
public class AdminCategoryController {

    private final CategoryService categoryService;

    @Autowired
    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/category")
    public String adminCategoriesPage(Model model) {
        model.addAttribute("activePage", "Categories");
        model.addAttribute("categories", categoryService.findAll());
        return "admin/category";
    }

    @GetMapping("/admin/category/{id}/edit")
    public String adminEditCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit");
        model.addAttribute("activePage", "Categories");
        model.addAttribute("category", categoryService.findById(id));
        return "admin/category_form";
    }

    @GetMapping("/admin/category/{id}/delete")
    public String adminDeleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/create")
    public String adminCreateProduct(Model model) {
        model.addAttribute("create");
        model.addAttribute("activePage", "Categories");
        model.addAttribute("category", new Category());
        return "admin/category_form";
    }

    @PostMapping("/admin/category")
    public String adminInsertProduct(@Valid Category category, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Categories");
        if (bindingResult.hasErrors())
            return "admin/category_form";
        categoryService.save(category);
        return "redirect:/admin/category";
    }
}
