package com.taltech.gelateria;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.repository.IceCreamRepository;
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
	public CommandLineRunner initIceCreams (IceCreamRepository repository) {
		return (args) -> {
			repository.save(new IceCream("Sorbet", "Lemon", 3));

		};
	}
}
