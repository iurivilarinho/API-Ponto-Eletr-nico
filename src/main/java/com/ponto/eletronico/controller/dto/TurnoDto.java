package com.ponto.eletronico.controller.dto;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ponto.eletronico.models.Escala;
import com.ponto.eletronico.models.Turno;

public class TurnoDto {

	private Long id;
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
	
	public TurnoDto(Turno turno) {
		this.id = turno.getId();
		this.idEscala = turno.getIdEscala();
		this.cod = turno.getCod();
		this.hrsMes = turno.getHrsMes();
		this.minHrAlmoco = turno.getMinHrAlmoco();
		this.maxHrAlmoco = turno.getMaxHrAlmoco();
		this.hrsDescanso = turno.getHrsDescanso();
		this.hrsAntes = turno.getHrsAntes();
		this.hrsDepois = turno.getHrsDepois();
		this.iniHrNoturna = turno.getIniHrNoturna();
		this.fimHrNoturna = turno.getFimHrNoturna();
		this.interjornada = turno.getInterjornada();
		this.descricao = turno.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public Escala getIdEscala() {
		return idEscala;
	}

	public int getCod() {
		return cod;
	}

	public LocalTime getHrsMes() {
		return hrsMes;
	}

	public LocalTime getMinHrAlmoco() {
		return minHrAlmoco;
	}

	public LocalTime getMaxHrAlmoco() {
		return maxHrAlmoco;
	}

	public LocalTime getHrsDescanso() {
		return hrsDescanso;
	}

	public LocalTime getHrsAntes() {
		return hrsAntes;
	}

	public LocalTime getHrsDepois() {
		return hrsDepois;
	}

	public LocalTime getIniHrNoturna() {
		return iniHrNoturna;
	}

	public LocalTime getFimHrNoturna() {
		return fimHrNoturna;
	}

	public LocalTime getInterjornada() {
		return interjornada;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static List<TurnoDto> converter(List<Turno> turno){
		return turno.stream().map(TurnoDto::new).collect(Collectors.toList());
	} 
}
