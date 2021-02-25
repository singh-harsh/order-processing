package com.egen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    public enum Status {
        CREATED,
        CANCELLED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long order_id;

    @Column(nullable = false)
    private Status order_status;

    @OneToMany(mappedBy="ord",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<OrderItem> orderItems = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="FK_customer_id",
            referencedColumnName = "customer_id",
            foreignKey = @ForeignKey(
                    name = "customer_order_fk"
            ))
    private Customer cus;

    @Column(nullable = false)
    private float subTotal;

    @Column(nullable = false)
    private float tax;

    @Column(nullable = false)
    private float shippingCharges;

    @Column(nullable = false)
    private float orderTotal;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date orderCreateDate;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date orderModifyDate;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public Status getOrder_status() {
        return order_status;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(float shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getOrderModifyDate() {
        return orderModifyDate;
    }

    public void setOrderModifyDate(Date orderModifyDate) {
        this.orderModifyDate = orderModifyDate;
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date utilTimestampDate) {
        this.orderCreateDate = utilTimestampDate;
    }

    public void setOrder_status(Status order_status) {
        this.order_status = order_status;
    }
}
