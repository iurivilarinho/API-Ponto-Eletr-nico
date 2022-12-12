package com.ponto.eletronico.models;


import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Escala {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int cod;
	private String diaSemana;
	private Boolean diaTrabalhado;
	private Boolean dsr;
	private LocalTime entrada;
	private LocalTime saida;
	
	public Escala() {
		
	}
	
	public Escala(int cod, String diaSemana, Boolean diaTrabalhado, LocalTime entrada, LocalTime saida, Boolean dsr) {
		this.cod = cod;
		this.diaSemana = diaSemana;
		this.diaTrabalhado = diaTrabalhado;
		this.dsr = dsr;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Boolean getDiaTrabalhado() {
		return diaTrabalhado;
	}

	public void setDiaTrabalhado(Boolean diaTrabalhado) {
		this.diaTrabalhado = diaTrabalhado;
	}
	

	public Boolean getDsr() {
		return dsr;
	}

	public void setDsr(Boolean dsr) {
		this.dsr = dsr;
	}

	public LocalTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalTime entrada) {
		this.entrada = entrada;
	}

	public LocalTime getSaida() {
		return saida;
	}

	public void setSaida(LocalTime saida) {
		this.saida = saida;
	}
	
	
	
}

//javatime
//https://blog.cvinicius.com.br/2018/08/utilizando-localdate-localdatetime-e.html
//https://www.baeldung.com/java-get-day-of-week