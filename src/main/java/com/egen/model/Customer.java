package com.egen.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private long customer_id;

    private String first_name;

    private String last_name;

    @OneToMany(mappedBy="cus")
    private Set<Order> customerOrders = new HashSet<>();

    @OneToMany(mappedBy="cusPayment")
    private Set<Payment> customerPayments = new HashSet<>();

    @OneToOne
    private BillingAddress billingAddress;

    @OneToOne
    private ShippingAddress shippingAddress;
}
