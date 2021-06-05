package com.stefan.salaryapp.controller;

import com.stefan.jooq.model.tables.pojos.Cities;
import com.stefan.salaryapp.repository.CityRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/city")
    public List<Cities> getSalaries() {
        return cityRepository.getCities();
    }

}
