package com.controleDePontoEAcesso.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
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
public class Movement {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public class MovimentId implements Serializable{ //trata o problema de chave composta
		private static final long serialVersionUID = 1L;
		private Long movimentId;
		private Long userId;
	}
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private MovimentId id;
	
	private LocalDateTime startDate;
	private LocalDateTime exitDate;
	private BigDecimal permanency;
	
	@ManyToOne
	private Occurrence occurence;
	
	@ManyToOne
	private Calendar calendarSpecialDate;
	
}
