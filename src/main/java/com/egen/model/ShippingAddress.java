package com.egen.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddress extends Address{

    @OneToOne(mappedBy = "shippingAddress")
    private Customer customerShippingAdd;
}