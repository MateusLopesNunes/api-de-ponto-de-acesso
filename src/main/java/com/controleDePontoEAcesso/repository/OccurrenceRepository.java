package com.controleDePontoEAcesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controleDePontoEAcesso.model.AcessLevel;
import com.controleDePontoEAcesso.model.Occurrence;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
