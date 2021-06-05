package com.stefan.salaryapp.controller;

import com.stefan.jooq.model.tables.pojos.JobAreas;
import com.stefan.salaryapp.repository.JobAreaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class JobAreaController {

    private final JobAreaRepository jobAreaRepository;

    public JobAreaController(JobAreaRepository jobAreaRepository) {
        this.jobAreaRepository = jobAreaRepository;
    }

    @GetMapping("/jobArea")
    public List<JobAreas> getSalaries() {
        return jobAreaRepository.getJobAreas();
    }

}
