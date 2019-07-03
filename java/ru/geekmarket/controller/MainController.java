package com.geekbrains.spring2.controller;

import com.geekbrains.spring2.controller.obj.CartItem;
import com.geekbrains.spring2.persist.model.Product;
import com.geekbrains.spring2.service.CartService;
import com.geekbrains.spring2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private final ProductService productService;
    private final CartService cartService;

    @Autowired
    public MainController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkoutPage() {
        return "checkout";
    }

    @GetMapping("/product/{id}")
    public String productPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("/store")
    public String storePage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "store";
    }

    @PostMapping("/cart/update")
    public String updateCart(CartItem cartItem, HttpServletRequest httpServletRequest) {
        Product product = productService.findById(cartItem.getProductId());
        if (product != null)
            cartService.addAmount(product, cartItem.getAmount());
        return "redirect:" + cartItem.getPageUrl();
    }
}
