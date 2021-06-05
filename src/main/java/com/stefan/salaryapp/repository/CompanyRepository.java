package com.stefan.salaryapp.repository;

import com.stefan.jooq.model.tables.pojos.Companies;
import com.stefan.jooq.model.tables.records.CompaniesRecord;
import com.stefan.salaryapp.dto.Company;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.stefan.jooq.model.Tables.CITIES;
import static com.stefan.jooq.model.Tables.COMPANIES;

@Repository
public class CompanyRepository {

    @Autowired
    private final DSLContext dslContext;

    public CompanyRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Transactional
    public List<Company> getCompanies() {
        return dslContext.select(
            COMPANIES.COMPANY_ID,
            COMPANIES.COMPANY_NAME,
            CITIES.CITY_NAME.as("headquarters"),
            COMPANIES.FOUNDED,
            COMPANIES.NO_OF_EMPLOYEES,
            COMPANIES.WEBSITE
        )
            .from(COMPANIES)
            .innerJoin(CITIES).on(CITIES.CITY_ID.eq(COMPANIES.HEADQUARTERS))
            .fetchInto(Company.class);

    }

    @Transactional
    public CompaniesRecord addCompany(Companies company) {
        var companiesRecord = new CompaniesRecord();
        companiesRecord.setCompanyName(company.getCompanyName());
        companiesRecord.setHeadquarters(company.getHeadquarters());
        companiesRecord.setFounded(company.getFounded());
        companiesRecord.setNoOfEmployees(company.getNoOfEmployees());
        companiesRecord.setWebsite(company.getWebsite());

        return  dslContext.insertInto(COMPANIES)
            .set(companiesRecord)
            .returning()
            .fetchOne();
    }

    @Transactional
    public void deleteCompany(Integer id) {
        dslContext.delete(COMPANIES)
            .where(COMPANIES.COMPANY_ID.eq(id))
            .execute();
    }
    @Transactional
    public void updateCompany(Companies company, Integer id) {
        dslContext.update(COMPANIES)
            .set(COMPANIES.COMPANY_NAME, company.getCompanyName())
            .set(COMPANIES.HEADQUARTERS, company.getHeadquarters())
            .set(COMPANIES.FOUNDED, company.getFounded())
            .set(COMPANIES.NO_OF_EMPLOYEES, company.getNoOfEmployees())
            .set(COMPANIES.WEBSITE, company.getWebsite())
            .where(COMPANIES.COMPANY_ID.eq(id))
            .execute();
    }
}
