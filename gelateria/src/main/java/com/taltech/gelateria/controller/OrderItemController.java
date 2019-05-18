package com.taltech.gelateria.controller;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.model.OrderItem;
import com.taltech.gelateria.service.OrderItemDTO;
import com.taltech.gelateria.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @GetMapping
    public List<OrderItemDTO> findAll() {
        return orderItemService.findAll();
    }
    @PostMapping
    public OrderItemDTO save(@RequestBody OrderItemDTO orderItem) {
        return orderItemService.orderItem(orderItem);
    }
}
