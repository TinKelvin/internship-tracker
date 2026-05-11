package com.KTSY.InternshipTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KTSY.InternshipTracker.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}