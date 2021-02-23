package com.egen.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customer_id;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
//    private Set<Order> placedOrders = new HashSet<>(0);
}
