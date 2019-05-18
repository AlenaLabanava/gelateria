package com.taltech.gelateria.service;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.model.OrderItem;
import com.taltech.gelateria.model.Topping;
import com.taltech.gelateria.repository.IceCreamRepository;
import com.taltech.gelateria.repository.OrderItemRepository;
import com.taltech.gelateria.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderItemService {

    @Autowired
    private IceCreamRepository iceCreamRepository;
    @Autowired
    private ToppingRepository toppingRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    public OrderItemDTO orderItem (OrderItemDTO orderItem ) {
        OrderItem dbOrderItem = new OrderItem();

        dbOrderItem.setIceCream(getOrderedIceCream(orderItem));
        dbOrderItem.setTopping(getOrderedTopping(orderItem));
        dbOrderItem.setPrice(getTotalPrice(orderItem));


        OrderItem saved = orderItemRepository.save(dbOrderItem);
        return convert(saved);
    }

  public List<OrderItemDTO> findAll() {
        return orderItemRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }



    private IceCream getOrderedIceCream(OrderItemDTO orderItem) {
        Optional<IceCream> dbIceCreamOp = iceCreamRepository.findById(orderItem.getIceCream().getId());
        IceCream dbIceCream = dbIceCreamOp.orElseThrow(RuntimeException::new);
        return dbIceCream;
    }

    private Topping getOrderedTopping(OrderItemDTO orderItem) {
        Optional<Topping> dbToppingOp = toppingRepository.findById(orderItem.getTopping().getId());
        Topping dbTopping = dbToppingOp.orElseThrow(RuntimeException::new);
        return dbTopping;
    }
    private Double getTotalPrice(OrderItemDTO orderItem) {
        Double totalPrice = 0.0;
        totalPrice = orderItem.getTopping().getPrice() + orderItem.getIceCream().getPrice();
        return totalPrice;
    }
    private OrderItemDTO convert(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setIceCream(orderItem.getIceCream());
        orderItemDTO.setTopping(orderItem.getTopping());
        orderItemDTO.setPrice(orderItem.getPrice());
        return orderItemDTO;
    }
}
