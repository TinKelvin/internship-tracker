package com.KTSY.InternshipTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.KTSY.InternshipTracker.model.Application;
import com.KTSY.InternshipTracker.repository.ApplicationRepository;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationRepository repository;

    public ApplicationController(ApplicationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return repository.findAll();
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
    return repository.save(application);
    }

}