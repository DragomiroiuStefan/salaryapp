package com.stefan.salaryapp.controller;

import com.stefan.jooq.model.tables.pojos.Companies;
import com.stefan.jooq.model.tables.records.CompaniesRecord;
import com.stefan.salaryapp.dto.Company;
import com.stefan.salaryapp.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CompanyController {

    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    public CompanyController(ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/company")
    public List<Company> getSalaries() {
        return companyRepository.getCompanies();
    }

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Companies insertProduct(@RequestBody Companies company) {
        CompaniesRecord companiesRecord = companyRepository.addCompany(company);
        return modelMapper.map(companiesRecord, Companies.class);

    }

    @DeleteMapping("/company/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        companyRepository.deleteCompany(id);
    }

    @PutMapping("/company/{id}")
    public void updateProduct(@RequestBody Companies company, @PathVariable Integer id) {
        companyRepository.updateCompany(company, id);
    }

}
