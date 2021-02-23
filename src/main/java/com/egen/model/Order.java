package com.egen.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {
    public enum Status {
        CREATED,
        CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    @Column(nullable = false)
    private Status order_status;

    @OneToMany(mappedBy = "orderPlaced")
    private List<LineItem> lineItems = new ArrayList<LineItem>();

    @Column(nullable = false)
    private float subTotal;

    @Column(nullable = false)
    private float tax;

    @Column(nullable = false)
    private float shippingCharges;

    @Column(nullable = false)
    private float orderTotal;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Customer customer;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Payment> payment;
//
//    @OneToOne
//    private BillingAddress billingAddress;
//
//    @OneToOne
//    private ShippingAddress shippingAddress;

    public void setOrder_status(Status order_status) {
        this.order_status = order_status;
    }
}
