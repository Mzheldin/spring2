package com.geekbrains.spring2.controller.admin;

import com.geekbrains.spring2.persist.model.Product;
import com.geekbrains.spring2.persist.repo.CategoryRepository;
import com.geekbrains.spring2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.geekbrains.spring2.persist.model.User;
import com.geekbrains.spring2.persist.repo.RoleRepository;
import com.geekbrains.spring2.service.UserService;
import com.geekbrains.spring2.service.model.SystemUser;

import javax.validation.Valid;

@Controller
public class AdminController {

    private final RoleRepository roleRepository;

    private final UserService userService;

    private final ProductService productService;

    private final CategoryRepository categoryRepository;

    @Autowired
    public AdminController(RoleRepository roleRepository, @Lazy UserService userService,
                           ProductService productService, CategoryRepository categoryRepository) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/admin")
    public String adminIndexPage(Model model) {
        model.addAttribute("activePage", "None");
        return "admin/index";
    }

    @GetMapping("/admin/roles")
    public String adminRolesPage(Model model) {
        model.addAttribute("activePage", "Roles");
        return "admin/index";
    }

}
