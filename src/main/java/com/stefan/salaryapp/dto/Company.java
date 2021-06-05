package com.stefan.salaryapp.dto;

import java.time.LocalDate;

public class Company {

    private Integer   companyId;
    private String    companyName;
    private String   headquarters;
    private LocalDate founded;
    private Integer   noOfEmployees;
    private String    website;

    public Company(Integer companyId, String companyName, String headquarters, LocalDate founded, Integer noOfEmployees, String website) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.headquarters = headquarters;
        this.founded = founded;
        this.noOfEmployees = noOfEmployees;
        this.website = website;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public void setFounded(LocalDate founded) {
        this.founded = founded;
    }

    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    public void setNoOfEmployees(Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
