package com.taltech.gelateria.service;


import com.taltech.gelateria.model.Topping;
import com.taltech.gelateria.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
@Service
public class ToppingService {



    @Autowired
    private ToppingRepository toppingRepository;


    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }

    public Topping findOne(Long id) {
        return toppingRepository.findById(id)
                .orElseThrow(this::badRequest);
    }

    public Topping save(Topping topping) {
        return toppingRepository.save(topping);
    }

    public Topping update(Topping topping, Long id) {
        Topping dbTopping = findOne(id);
        dbTopping.setName(topping.getName());
        dbTopping.setPrice(topping.getPrice());
        return toppingRepository.save(topping);
    }

    public void delete(Long id) {
        Topping dbTopping = findOne(id);
        toppingRepository.delete(dbTopping);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "id doesnt exist");
    }
}



