package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class Payment {

    @Id
    private long confirmationNumber;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String date;

//    @ManyToOne
//    private Order placedOrder;

}
