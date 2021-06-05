package com.stefan.salaryapp.repository;

import com.stefan.jooq.model.tables.pojos.CareerLevels;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.stefan.jooq.model.Tables.CAREER_LEVELS;

@Repository
public class CareerLevelRepository {

    @Autowired
    private final DSLContext dslContext;

    public CareerLevelRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Transactional
    public List<CareerLevels> getCareerLevels() {
        return dslContext.select()
            .from(CAREER_LEVELS)
            .fetchInto(CareerLevels.class);

    }
}
