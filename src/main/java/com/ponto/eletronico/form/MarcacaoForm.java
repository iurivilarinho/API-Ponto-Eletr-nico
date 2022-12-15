package com.ponto.eletronico.form;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ponto.eletronico.models.Marcacao;
import com.ponto.eletronico.models.TipoMarcacao;
import com.ponto.eletronico.models.Turno;
import com.ponto.eletronico.models.Usuario;
import com.ponto.eletronico.repository.MarcacaoRepository;
import com.ponto.eletronico.repository.TipoMarcacaoRepository;
import com.ponto.eletronico.repository.TurnoRepository;
import com.ponto.eletronico.repository.UsuarioRepository;


public class MarcacaoForm {

	private Long idTurno;
	private Long idUsuario;
	private LocalDate dia;
	private LocalTime hora;
	private Long tipo;
	private String longitude;
	private String latitude;
	
	
	
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



	public LocalDate getDia() {
		return dia;
	}



	public void setDia(LocalDate dia) {
		this.dia = dia;
	}



	public LocalTime getHora() {
		return hora;
	}



	public void setHora(LocalTime hora) {
		this.hora = hora;
	}



	public Long getTipo() {
		return tipo;
	}



	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public Marcacao formulario(TurnoRepository turnoRepository, UsuarioRepository usuarioRepository, TipoMarcacaoRepository tipoRepository) {
		
		TipoMarcacao tipomarcacao = tipoRepository.getReferenceById(tipo);
		Turno turno = turnoRepository.getReferenceById(idTurno);
		Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
		Marcacao marcacao = new Marcacao();
		
		marcacao.setDia(dia);
		marcacao.setHora(hora);
		marcacao.setIdTurno(turno);
		marcacao.setIdUsuario(usuario);
		marcacao.setLatitude(latitude);
		marcacao.setLongitude(longitude);
		marcacao.setTipo(tipomarcacao);
		
		return marcacao;
	}
		
	
	public Marcacao atualizar(Long id, MarcacaoRepository marcacaoRepository, TurnoRepository turnoRepository, UsuarioRepository usuarioRepository, TipoMarcacaoRepository tipoRepository) {
		Marcacao marcacao = marcacaoRepository.getReferenceById(id);
		TipoMarcacao tipomarcacao = tipoRepository.getReferenceById(tipo);
		Turno turno = turnoRepository.getReferenceById(idTurno);
		Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
	
		marcacao.setDia(dia);
		marcacao.setHora(hora);
		marcacao.setIdTurno(turno);
		marcacao.setIdUsuario(usuario);
		marcacao.setLatitude(latitude);
		marcacao.setLongitude(longitude);
		marcacao.setTipo(tipomarcacao);
		
		return marcacao;
		
	}
}
