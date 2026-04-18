package com.example.ecommerce.service;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    private final CartRepository repo;
    private final ProductRepository productRepo;

    public CartService(CartRepository repo, ProductRepository productRepo){
        this.repo = repo; this.productRepo = productRepo;
    }

    public CartItem addToCart(Long productId, int qty){
        Product product = productRepo.findById(productId).orElseThrow();
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(qty);
        return repo.save(item);
    }

    public void removeFromCart(Long cartItemId){
        repo.deleteById(cartItemId);
    }

    public List<CartItem> getCart(){ return repo.findAll(); }
}
