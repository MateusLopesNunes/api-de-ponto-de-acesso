package com.controleDePontoEAcesso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JourneyWork { //jornada de trabalho

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String description;
}
