package com.ponto.eletronico.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Periodo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Turno idTurno;
	@ManyToOne
	private Usuario idUsuario;
	private String mes;
	private String ano;
	private LocalDate iniCalculo;
	private LocalDate fimCalculo;
	private int qtdDias;
	private LocalTime hrDia;
	private int diasNaoTrab;
	
	
	public Periodo() {
		
	}
	
public Periodo(String mes, String ano, LocalDate iniCalculo, LocalDate fimCalculo, Turno idTurno, int qtdDias, LocalTime hrDia, int diasNaoTrab, Usuario idUsuario) {
		this.mes = mes;
		this.ano = ano;
		this.iniCalculo = iniCalculo;
		this.fimCalculo = fimCalculo;
		this.idTurno = idTurno;
		this.idUsuario = idUsuario;
		this.qtdDias = qtdDias;
		this.hrDia = hrDia;
		this.diasNaoTrab = diasNaoTrab;		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public LocalDate getIniCalculo() {
		return iniCalculo;
	}
	
	public void setIniCalculo(LocalDate iniCalculo) {
		this.iniCalculo = iniCalculo;
	}
	
	public LocalDate getFimCalculo() {
		return fimCalculo;
	}
	
	public void setFimCalculo(LocalDate fimCalculo) {
		this.fimCalculo = fimCalculo;
	}
	
	public Turno getIdTurno() {
		return idTurno;
	}
	
	public void setIdTurno(Turno idTurno) {
		this.idTurno = idTurno;
	}
	
	
	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getQtdDias() {
		return qtdDias;
	}
	
	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	
	public LocalTime getHrDia() {
		return hrDia;
	}
	
	public void setHrDia(LocalTime hrDia) {
		this.hrDia = hrDia;
	}
	
	public int getDiasNaoTrab() {
		return diasNaoTrab;
	}
	
	public void setDiasNaoTrab(int diasNaoTrab) {
		this.diasNaoTrab = diasNaoTrab;
	}


}
