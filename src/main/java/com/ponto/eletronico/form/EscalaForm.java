package com.ponto.eletronico.form;

import java.time.LocalTime;

import com.ponto.eletronico.models.Escala;

public class EscalaForm {

	private int cod;
	private String diaSemana;
	private Boolean diaTrabalhado;
	private Boolean dsr;
	private LocalTime entrada;
	private LocalTime saida;
	
	
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
	
	public Escala formulario() {
		Escala escala = new Escala();
		
		escala.setCod(cod);
		escala.setDiaSemana(diaSemana);
		escala.setDiaTrabalhado(diaTrabalhado);
		escala.setDsr(dsr);
		escala.setEntrada(entrada);
		escala.setSaida(saida);
		
		return escala;
	}
}
