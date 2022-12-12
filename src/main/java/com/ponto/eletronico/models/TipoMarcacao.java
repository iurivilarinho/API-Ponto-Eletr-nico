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
	private int cod;
	private String desc;
	private LocalTime max;
	private LocalTime min;
	
	
	public TipoMarcacao() {
		
	}
	
public TipoMarcacao(int cod, String desc, LocalTime max, LocalTime min) {
		this.cod = cod;
		this.desc = desc;
		this.max = max;
		this.min = min;
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

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
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
