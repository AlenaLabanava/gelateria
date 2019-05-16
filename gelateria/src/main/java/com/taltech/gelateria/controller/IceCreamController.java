package com.taltech.gelateria.controller;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.service.IceCreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gelateria")
public class IceCreamController {

    @Autowired
    private IceCreamService iceCreamService;


        @GetMapping
        public List<IceCream> findAll() {
            return iceCreamService.findAll();
        }

        @GetMapping("{id}")
        public IceCream findOne(@PathVariable Long id) {
            return iceCreamService.findOne(id);
        }

        @PostMapping
        public IceCream save(@RequestBody IceCream iceCream) {
            return iceCreamService.save(iceCream);
        }

        @PutMapping("{id}")
        public IceCream update (@RequestBody IceCream iceCream, @PathVariable Long id) {
            return iceCreamService.update(iceCream, id);
        }


        @DeleteMapping("{id}")
        public void delete(@PathVariable Long id) {
            iceCreamService.delete(id);
        }

}
