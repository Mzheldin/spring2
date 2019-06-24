package com.geekbrains.spring2.controller.admin;

import com.geekbrains.spring2.persist.model.User;
import com.geekbrains.spring2.persist.repo.RoleRepository;
import com.geekbrains.spring2.service.UserService;
import com.geekbrains.spring2.service.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    private final RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public AdminUserController(RoleRepository roleRepository, @Lazy UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/admin/user")
    public String adminUsersPage(Model model) {
        model.addAttribute("activePage", "Users");
        model.addAttribute("users", userService.findAll());
        return "admin/user";
    }

    @GetMapping("/admin/user/{id}/edit")
    public String adminEditUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit");
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user_form";
    }

    @GetMapping("/admin/user/{id}/delete")
    public String adminDeleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/create")
    public String adminCreateUser(Model model) {
        model.addAttribute("create");
        model.addAttribute("activePage", "Users");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user_form";
    }

    @PostMapping("/admin/user")
    public String adminInsertUser(@Valid SystemUser user, Model model, BindingResult bindingResult) {
        model.addAttribute("activePage", "Users");

        if (bindingResult.hasErrors()) {
            return "admin/user_form";
        }

        userService.save(user);
        return "redirect:/admin/user";
    }
}
