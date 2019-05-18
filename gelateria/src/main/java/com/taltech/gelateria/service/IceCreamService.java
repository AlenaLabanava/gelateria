package com.taltech.gelateria.service;

import com.taltech.gelateria.model.IceCream;
import com.taltech.gelateria.repository.IceCreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class IceCreamService {

    @Autowired
    private IceCreamRepository iceCreamRepository;


    public List<IceCream> findAll() {
        return iceCreamRepository.findAll();
    }

    public IceCream findOne(Long id) {
        return iceCreamRepository.findById(id)
                .orElseThrow(this::badRequest);
    }

    public IceCream save(IceCream iceCream) {
        return iceCreamRepository.save(iceCream);
    }

    public IceCream update(IceCream iceCream, Long id) {
        IceCream dbIceCream = findOne(id);
        dbIceCream.setType(iceCream.getType());
        dbIceCream.setTaste(iceCream.getTaste());
        dbIceCream.setPrice(iceCream.getPrice());
        return iceCreamRepository.save(iceCream);
    }

    public void delete(Long id) {
        IceCream dbIceCream = findOne(id);
        iceCreamRepository.delete(dbIceCream);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "id doesnt exist");
    }
}
