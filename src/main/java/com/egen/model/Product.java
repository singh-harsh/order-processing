package com.egen.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private String product_id;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private long product_price;

    @OneToOne
    private LineItem lineItem;
}
