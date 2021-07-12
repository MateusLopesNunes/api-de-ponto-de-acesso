package com.controleDePontoEAcesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controleDePontoEAcesso.model.AcessLevel;
import com.controleDePontoEAcesso.model.BankHours;

@Repository
public interface BankHoursRepository extends JpaRepository<BankHours, Long> {
}
