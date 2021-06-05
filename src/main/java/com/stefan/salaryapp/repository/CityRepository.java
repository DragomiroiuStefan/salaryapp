package com.stefan.salaryapp.repository;

import com.stefan.jooq.model.tables.pojos.Cities;
import com.stefan.jooq.model.tables.pojos.JobAreas;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.stefan.jooq.model.Tables.CITIES;
import static com.stefan.jooq.model.Tables.JOB_AREAS;

@Repository
public class CityRepository {

    @Autowired
    private final DSLContext dslContext;

    public CityRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Transactional
    public List<Cities> getCities() {
        return dslContext.select()
            .from(CITIES)
            .fetchInto(Cities.class);

    }
}
