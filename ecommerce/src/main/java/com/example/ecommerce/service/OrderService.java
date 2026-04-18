package com.example.ecommerce.service;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;
    private final CartRepository cartRepo;

    public OrderService(OrderRepository repo, CartRepository cartRepo){
        this.repo = repo; this.cartRepo = cartRepo;
    }

    public Order placeOrder(){
        List<CartItem> items = cartRepo.findAll();
        double total = items.stream()
                            .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                            .sum();
        Order order = new Order();
        order.setItems(items);
        order.setTotalAmount(total);
        cartRepo.deleteAll(); // clear cart after order
        return repo.save(order);
    }
}
