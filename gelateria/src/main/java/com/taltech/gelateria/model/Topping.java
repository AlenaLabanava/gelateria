package com.taltech.gelateria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String taste;
    private Integer price;

    public Topping(){
    }

    public Topping(String taste, Integer price) {
        this.taste = taste;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
