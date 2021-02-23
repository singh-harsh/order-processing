package com.egen.model;

import javax.persistence.*;

@Entity
public class LineItem {

    @Id
    private long lineItemId;

    @OneToOne
    private Product item;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order orderPlaced;
}
