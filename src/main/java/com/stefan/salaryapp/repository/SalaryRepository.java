package com.stefan.salaryapp.repository;

import com.stefan.salaryapp.dto.Salary;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.stefan.jooq.model.Tables.*;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.SQLDataType.VARCHAR;

@Repository
public class SalaryRepository {

    @Autowired
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
//            concat(
//                CAREER_LEVELS.MIN_YEARS_OF_EXPERIENCE.cast(VARCHAR(2)),
//                " - ",
//                CAREER_LEVELS.MAX_YEARS_OF_EXPERIENCE.cast(VARCHAR(2))
//            ),
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
}
