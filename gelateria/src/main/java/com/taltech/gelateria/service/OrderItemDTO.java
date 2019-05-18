package com.taltech.gelateria.service;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.model.Topping;

public class OrderItemDTO {

    private Long id;
    private IceCream iceCream;
    private Topping topping;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
