package com.ponto.eletronico.models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Turno {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Escala idEscala;
	private int cod;
	private LocalTime hrsMes;
	private LocalTime minHrAlmoco;
	private LocalTime maxHrAlmoco;
	private LocalTime hrsDescanso;
	private LocalTime hrsAntes;
	private LocalTime hrsDepois;
	private LocalTime iniHrNoturna;
	private LocalTime fimHrNoturna;
	private LocalTime interjornada;
	private String descricao;
	
	public Turno() {
		
	}
	
	public Turno(int cod, LocalTime hrsMes, LocalTime minHrAlmoco, LocalTime maxHrAlmoco, LocalTime hrsDescanso, LocalTime hrsAntes, LocalTime hrsDepois, LocalTime iniHrNoturna, LocalTime fimHrNoturna, LocalTime interjornada, String descricao, Escala idEscala) {
		this.cod = cod;
		this.idEscala = idEscala;
		this.hrsMes = hrsMes;
		this.minHrAlmoco = minHrAlmoco;
		this.maxHrAlmoco = maxHrAlmoco;
		this.hrsDescanso = hrsDescanso;
		this.hrsAntes = hrsAntes;
		this.hrsDepois = hrsDepois;
		this.iniHrNoturna = iniHrNoturna;
		this.fimHrNoturna = fimHrNoturna;
		this.interjornada = interjornada;
		this.descricao = descricao;
		
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
	

	public Escala getIdEscala() {
		return idEscala;
	}

	public void setIdEscala(Escala idEscala) {
		this.idEscala = idEscala;
	}

	public LocalTime getHrsMes() {
		return hrsMes;
	}

	public void setHrsMes(LocalTime hrsMes) {
		this.hrsMes = hrsMes;
	}

	public LocalTime getMinHrAlmoco() {
		return minHrAlmoco;
	}

	public void setMinHrAlmoco(LocalTime minHrAlmoco) {
		this.minHrAlmoco = minHrAlmoco;
	}

	public LocalTime getMaxHrAlmoco() {
		return maxHrAlmoco;
	}

	public void setMaxHrAlmoco(LocalTime maxHrAlmoco) {
		this.maxHrAlmoco = maxHrAlmoco;
	}

	public LocalTime getHrsDescanso() {
		return hrsDescanso;
	}

	public void setHrsDescanso(LocalTime hrsDescanso) {
		this.hrsDescanso = hrsDescanso;
	}

	public LocalTime getHrsAntes() {
		return hrsAntes;
	}

	public void setHrsAntes(LocalTime hrsAntes) {
		this.hrsAntes = hrsAntes;
	}

	public LocalTime getHrsDepois() {
		return hrsDepois;
	}

	public void setHrsDepois(LocalTime hrsDepois) {
		this.hrsDepois = hrsDepois;
	}

	public LocalTime getIniHrNoturna() {
		return iniHrNoturna;
	}

	public void setIniHrNoturna(LocalTime iniHrNoturna) {
		this.iniHrNoturna = iniHrNoturna;
	}

	public LocalTime getFimHrNoturna() {
		return fimHrNoturna;
	}

	public void setFimHrNoturna(LocalTime fimHrNoturna) {
		this.fimHrNoturna = fimHrNoturna;
	}

	public LocalTime getInterjornada() {
		return interjornada;
	}

	public void setInterjornada(LocalTime interjornada) {
		this.interjornada = interjornada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
