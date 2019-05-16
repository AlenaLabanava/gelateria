package com.taltech.gelateria.controller;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.model.Topping;
import com.taltech.gelateria.service.IceCreamService;
import com.taltech.gelateria.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppings")

public class ToppingController {

    @Autowired
    private ToppingService toppingService;


    @GetMapping
    public List<Topping> findAll() {
        return toppingService.findAll();
    }

    @GetMapping("{id}")
    public Topping findOne(@PathVariable Long id) {
        return toppingService.findOne(id);
    }

    @PostMapping
    public Topping save(@RequestBody Topping topping) {
        return toppingService.save(topping);
    }

    @PutMapping("{id}")
    public Topping update (@RequestBody Topping topping, @PathVariable Long id) {
        return toppingService.update(topping, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {toppingService.delete(id);
    }

}
