package com.stefan.salaryapp.repository;

import com.stefan.jooq.model.tables.pojos.Salaries;
import com.stefan.jooq.model.tables.records.SalariesRecord;
import com.stefan.salaryapp.dto.Salary;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.stefan.jooq.model.Tables.*;

@Repository
public class SalaryRepository {

    private final DSLContext dslContext;

    public SalaryRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Salary> getSalaries() {
        return dslContext.select(
            SALARIES.JOB_TITLE,
            JOB_AREAS.AREA_NAME,
            COMPANIES.COMPANY_NAME,
            CITIES.CITY_NAME,
            CAREER_LEVELS.LEVEL_NAME,
            SALARIES.ADDED,
            SALARIES.SALARY
        )
            .from(SALARIES)
            .innerJoin(JOB_AREAS).on(JOB_AREAS.AREA_ID.eq(SALARIES.AREA_ID))
            .innerJoin(COMPANIES).on(COMPANIES.COMPANY_ID.eq(SALARIES.COMPANY_ID))
            .innerJoin(CITIES).on(CITIES.CITY_ID.eq(SALARIES.LOCATION_ID))
            .innerJoin(CAREER_LEVELS).on(CAREER_LEVELS.LEVEL_ID.eq(SALARIES.LEVEL_ID))
            .fetchInto(Salary.class);
    }

    public SalariesRecord addSalary(Salaries salary) {
        var salariesRecord = new SalariesRecord();
        salariesRecord.setJobTitle(salary.getJobTitle());
        salariesRecord.setAreaId(salary.getAreaId());
        salariesRecord.setCompanyId(salary.getCompanyId());
        salariesRecord.setLocationId(salary.getLocationId());
        salariesRecord.setLevelId(salary.getLevelId());
        salariesRecord.setAdded(LocalDate.now());
        salariesRecord.setSalary(salary.getSalary());

        return  dslContext.insertInto(SALARIES)
            .set(salariesRecord)
            .returning()
            .fetchOne();
    }
}
