package com.controleDePontoEAcesso.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.controleDePontoEAcesso.model.Movement.MovimentId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankHours {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public class BankHoursId implements Serializable { //resolve problema da chave composta
		private static final long serialVersionUID = 1L;
		private Long bankHoursId;
		private Long movimentId;
		private Long userId;
	}
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BankHoursId id;
	
	private LocalDateTime WorkedHours;
	private BigDecimal qtdWorkHous;
	private BigDecimal saldoTrabalhadas;
	

}
