package com.controleDePontoEAcesso.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private CategoryUser categoryUser;
	private String name;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private JourneyWork journeyWork;
	private BigDecimal delayTolerance; //tolerancia por atraso
	private LocalDateTime startJourneyWork; //inicio da jornada de trabalho 
	private LocalDateTime exitJourneyWork; //saida da jornada de trabalho
}
