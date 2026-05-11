package com.KTSY.InternshipTracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
    repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Application updateApplication(
            @PathVariable Long id,
            @RequestBody Application updatedApplication) {

        Application application = repository.findById(id)
                .orElseThrow();

        application.setCompany(updatedApplication.getCompany());
        application.setRole(updatedApplication.getRole());
        application.setStatus(updatedApplication.getStatus());
        application.setLocation(updatedApplication.getLocation());
        application.setDateApplied(updatedApplication.getDateApplied());

        return repository.save(application);
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

}