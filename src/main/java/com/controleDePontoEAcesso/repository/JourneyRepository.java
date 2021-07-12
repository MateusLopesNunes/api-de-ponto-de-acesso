package com.controleDePontoEAcesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controleDePontoEAcesso.model.JourneyWork;

@Repository
public interface JourneyRepository extends JpaRepository<JourneyWork, Long> {
}
