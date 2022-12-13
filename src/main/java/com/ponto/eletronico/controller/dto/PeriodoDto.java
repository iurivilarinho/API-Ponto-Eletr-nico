package com.ponto.eletronico.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ponto.eletronico.models.Periodo;
import com.ponto.eletronico.models.Turno;
import com.ponto.eletronico.models.Usuario;

public class PeriodoDto {

	private Long id;
	private Turno idTurno;
	private Usuario idUsuario;
	private String mes;
	private String ano;
	private LocalDate iniCalculo;
	private LocalDate fimCalculo;
	private int qtdDias;
	private LocalTime hrDia;
	private int diasNaoTrab;
	
	public PeriodoDto(Periodo periodo) {
		this.id = periodo.getId();
		this.idTurno = periodo.getIdTurno();
		this.mes = periodo.getMes();
		this.ano = periodo.getAno();
		this.iniCalculo = periodo.getIniCalculo();
		this.fimCalculo = periodo.getFimCalculo();
		this.qtdDias = periodo.getQtdDias();
		this.hrDia = periodo.getHrDia();
		this.diasNaoTrab = periodo.getDiasNaoTrab();
	}

	public Long getId() {
		return id;
	}

	public Turno getIdTurno() {
		return idTurno;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public String getMes() {
		return mes;
	}

	public String getAno() {
		return ano;
	}

	public LocalDate getIniCalculo() {
		return iniCalculo;
	}

	public LocalDate getFimCalculo() {
		return fimCalculo;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public LocalTime getHrDia() {
		return hrDia;
	}

	public int getDiasNaoTrab() {
		return diasNaoTrab;
	}
	
	public static List<PeriodoDto> converter(List<Periodo> periodo){
		return periodo.stream().map(PeriodoDto::new).collect(Collectors.toList());
	}
	
}
