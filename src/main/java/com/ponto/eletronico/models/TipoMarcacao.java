package com.ponto.eletronico.models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoMarcacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private int cod;
	private LocalTime max;
	private LocalTime min;
	
	public TipoMarcacao() {
		
	}
	
	public TipoMarcacao(String descricao, int cod, LocalTime min, LocalTime max) {
		this.descricao = descricao;
		this.cod = cod;
		this.min = min;
		this.max = max;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return descricao;
	}

	public void setDesc(String descricao) {
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public LocalTime getMax() {
		return max;
	}

	public void setMax(LocalTime max) {
		this.max = max;
	}

	public LocalTime getMin() {
		return min;
	}

	public void setMin(LocalTime min) {
		this.min = min;
	}
	
	
}
