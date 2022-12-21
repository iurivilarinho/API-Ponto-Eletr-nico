package com.ponto.eletronico.controller.dto;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ponto.eletronico.models.Escala;

public class EscalaDto {

	private Long id;
	private int cod;
	private String diaSemana;
	private Boolean diaTrabalhado;
	private Boolean dsr;
	private LocalTime entrada;
	private LocalTime saida;
	private LocalTime hrsDia;

	public EscalaDto(Escala escala) {
		this.id = escala.getId();
		this.cod = escala.getCod();
		this.diaSemana = escala.getDiaSemana();
		this.diaTrabalhado = escala.getDiaTrabalhado();
		this.dsr = escala.getDsr();
		this.entrada = escala.getEntrada();
		this.saida = escala.getSaida();
		this.hrsDia = escala.getHrsDia();
	}

	public Long getId() {
		return id;
	}

	public int getCod() {
		return cod;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public Boolean getDiaTrabalhado() {
		return diaTrabalhado;
	}

	public Boolean getDsr() {
		return dsr;
	}

	public LocalTime getEntrada() {
		return entrada;
	}

	public LocalTime getSaida() {
		return saida;
	}

	public LocalTime getHrsDia() {
		return hrsDia;
	}

	public static List<EscalaDto> converter(List<Escala> escala) {

		return escala.stream().map(EscalaDto::new).collect(Collectors.toList());
	}
}
