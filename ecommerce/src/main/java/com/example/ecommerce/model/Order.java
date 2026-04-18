package com.example.ecommerce.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> items;

    private double totalAmount;

    // getters & setters
}

