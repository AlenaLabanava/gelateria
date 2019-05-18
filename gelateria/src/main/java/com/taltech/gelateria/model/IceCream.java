package com.taltech.gelateria.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IceCream {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String taste;
    private Double price;

    public IceCream(){
    }

    public IceCream (String type, String taste, Double price){
        this.type = type;
        this.taste = taste;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
