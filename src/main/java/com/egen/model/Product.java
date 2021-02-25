package com.egen.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private long product_id;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private long product_price;

    @Column(nullable = false)
    private long product_total_quantity;

    @OneToMany(mappedBy="pro",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<OrderItem> orderItems = new HashSet<>();
}
