package com.stefan.salaryapp.controller;

import com.stefan.jooq.model.tables.pojos.Salaries;
import com.stefan.jooq.model.tables.records.SalariesRecord;
import com.stefan.salaryapp.dto.Salary;
import com.stefan.salaryapp.repository.SalaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SalaryController {

    private final ModelMapper modelMapper;
    private final SalaryRepository salaryRepository;

    public SalaryController(ModelMapper modelMapper, SalaryRepository salaryRepository) {
        this.modelMapper = modelMapper;
        this.salaryRepository = salaryRepository;
    }

    @GetMapping("/salary")
    public List<Salary> getSalaries() {
        return salaryRepository.getSalaries();
    }

    @PostMapping("/salary")
    @ResponseStatus(HttpStatus.CREATED)
    public Salaries addSalary(@RequestBody Salaries salary) {
        SalariesRecord salariesRecord = salaryRepository.addSalary(salary);
        return modelMapper.map(salariesRecord, Salaries.class);
    }

}
