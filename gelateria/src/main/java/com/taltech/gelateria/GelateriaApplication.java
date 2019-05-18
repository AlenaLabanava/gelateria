package com.taltech.gelateria;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.model.OrderItem;
import com.taltech.gelateria.model.Topping;
import com.taltech.gelateria.repository.IceCreamRepository;
import com.taltech.gelateria.repository.OrderItemRepository;
import com.taltech.gelateria.repository.ToppingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GelateriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GelateriaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initIceCreams (IceCreamRepository repository, ToppingRepository toppingRepository, OrderItemRepository itemRepository ) {
		return (args) -> {
			IceCream ic = repository.save(new IceCream("Sorbet", "Lemon", 3.00));
			repository.save(new IceCream("Ordinary", "Vanilla", 3.50));
			repository.save(new IceCream("Vegan", "Stracciatella", 3.50));

			Topping tp= toppingRepository.save(new Topping("Chocolate Chips", 1.00));
			toppingRepository.save(new Topping("Crushed Peanuts", 0.50));

			itemRepository.save(new OrderItem(ic, tp, 4.00));

		};
	}



}
