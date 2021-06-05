package com.stefan.salaryapp.repository;

import com.stefan.jooq.model.tables.pojos.JobAreas;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.stefan.jooq.model.Tables.JOB_AREAS;

@Repository
public class JobAreaRepository {

    @Autowired
    private final DSLContext dslContext;

    public JobAreaRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Transactional
    public List<JobAreas> getJobAreas() {
        return dslContext.select()
            .from(JOB_AREAS)
            .fetchInto(JobAreas.class);

    }
}
