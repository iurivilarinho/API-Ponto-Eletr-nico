package com.ponto.eletronico.form;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ponto.eletronico.models.Periodo;
import com.ponto.eletronico.models.Turno;
import com.ponto.eletronico.models.Usuario;
import com.ponto.eletronico.repository.TurnoRepository;
import com.ponto.eletronico.repository.UsuarioRepository;

public class PeriodoForm {

	private Long idTurno;
	private Long idUsuario;
	private String mes;
	private String ano;
	private LocalDate iniCalculo;
	private LocalDate fimCalculo;
	private int qtdDias;
	private LocalTime hrDia;
	private int diasNaoTrab;
	
	
	
	public Long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
	
	public Periodo formulario(UsuarioRepository usuarioRepository, TurnoRepository turnoRepository) {
		
		Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
		Turno turno = turnoRepository.getReferenceById(idTurno);
		
		Periodo periodo = new Periodo();
		
		periodo.setAno(ano);
		periodo.setDiasNaoTrab(diasNaoTrab);
		periodo.setFimCalculo(fimCalculo);
		periodo.setIniCalculo(iniCalculo);
		periodo.setMes(mes);
		periodo.setQtdDias(qtdDias);
		periodo.setIdTurno(turno);
		periodo.setIdUsuario(usuario);
		periodo.setHrDia(hrDia);
		
		return periodo;
		
	}
}
