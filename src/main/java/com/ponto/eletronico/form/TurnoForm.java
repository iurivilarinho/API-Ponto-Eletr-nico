package com.ponto.eletronico.form;

import java.time.LocalTime;


import com.ponto.eletronico.models.Escala;
import com.ponto.eletronico.models.Turno;
import com.ponto.eletronico.repository.EscalaRepository;
import com.ponto.eletronico.repository.TurnoRepository;


public class TurnoForm {

	
	private Long idEscala;
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
	
	
	
	public Long getIdEscala() {
		return idEscala;
	}



	public void setIdEscala(Long idEscala) {
		this.idEscala = idEscala;
	}



	public int getCod() {
		return cod;
	}



	public void setCod(int cod) {
		this.cod = cod;
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



	public Turno formulario(EscalaRepository escalaRepository) {
		Escala escala = escalaRepository.getReferenceById(idEscala);
		Turno turno = new Turno();
		turno.setCod(cod);
		turno.setDescricao(descricao);
		turno.setFimHrNoturna(fimHrNoturna);
		turno.setIniHrNoturna(iniHrNoturna);
		turno.setHrsAntes(hrsAntes);
		turno.setHrsDepois(hrsDepois);
		turno.setHrsDescanso(hrsDescanso);
		turno.setHrsMes(hrsMes);
		turno.setIdEscala(escala);
		turno.setInterjornada(interjornada);
		turno.setMaxHrAlmoco(maxHrAlmoco);
		turno.setMinHrAlmoco(minHrAlmoco);
		
		return turno;
	}
	
	public Turno atualizar(Long id, EscalaRepository escalaRepository, TurnoRepository turnoRepository) {
		Escala escala = escalaRepository.getReferenceById(idEscala);
		Turno turno = turnoRepository.getReferenceById(id);
		turno.setCod(cod);
		turno.setDescricao(descricao);
		turno.setFimHrNoturna(fimHrNoturna);
		turno.setIniHrNoturna(iniHrNoturna);
		turno.setHrsAntes(hrsAntes);
		turno.setHrsDepois(hrsDepois);
		turno.setHrsDescanso(hrsDescanso);
		turno.setHrsMes(hrsMes);
		turno.setIdEscala(escala);
		turno.setInterjornada(interjornada);
		turno.setMaxHrAlmoco(maxHrAlmoco);
		turno.setMinHrAlmoco(minHrAlmoco);
		
		return turno;
	}
	
}
