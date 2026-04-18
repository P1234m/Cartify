package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService service;
    public CartController(CartService service){ this.service = service; }

    @GetMapping public List<CartItem> viewCart(){ return service.getCart(); }
    @PostMapping("/{productId}")
    public CartItem add(@PathVariable Long productId, @RequestParam int qty){
        return service.addToCart(productId, qty);
    }
    @DeleteMapping("/{cartItemId}")
    public void remove(@PathVariable Long cartItemId){ service.removeFromCart(cartItemId); }
}
