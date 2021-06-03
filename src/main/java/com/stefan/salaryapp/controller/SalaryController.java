package com.stefan.salaryapp.controller;

import com.stefan.salaryapp.dto.Salary;
import com.stefan.salaryapp.repository.SalaryRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SalaryController {

    private final SalaryRepository salaryRepository;

    public SalaryController(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @GetMapping("/salary")
    public List<Salary> getSalaries() {
        return salaryRepository.getSalaries();
    }

}
