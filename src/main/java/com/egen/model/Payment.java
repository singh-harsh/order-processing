package com.egen.model;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    private long paymentId;

    @Column(length = 16)
    private long card_number;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String expiry_date;

    @ManyToOne
    @JoinColumn(name="FK_customer_id",
            referencedColumnName = "customer_id",
            foreignKey = @ForeignKey(
                    name = "customer_payment_fk"
            ))
    private Customer cusPayment;
}
