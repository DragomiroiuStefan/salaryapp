package com.stefan.salaryapp.controller;

import com.stefan.jooq.model.tables.pojos.CareerLevels;
import com.stefan.salaryapp.repository.CareerLevelRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CareerLevelController {

    private final CareerLevelRepository careerLevelRepository;

    public CareerLevelController(CareerLevelRepository careerLevelRepository) {
        this.careerLevelRepository = careerLevelRepository;
    }

    @GetMapping("/careerLevel")
    public List<CareerLevels> getSalaries() {
        return careerLevelRepository.getCareerLevels();
    }

}
