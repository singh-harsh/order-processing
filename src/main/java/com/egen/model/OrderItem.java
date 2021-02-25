package com.egen.model;

import javax.persistence.*;

@Entity
@Table(name="ORDER_ITEMS")
public class OrderItem {

    @Id
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="FK_order_id",
            referencedColumnName = "order_id",
            foreignKey = @ForeignKey(
                    name = "ord_orderitem_fk"
            ))
    private Order ord;

    @ManyToOne
    @JoinColumn(name="FK_product_id",
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "pro_orderitem_fk"
            ))
    private Product pro;
}
