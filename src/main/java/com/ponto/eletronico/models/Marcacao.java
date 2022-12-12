package com.ponto.eletronico.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Marcacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Turno idTurno;
	@ManyToOne
	private Usuario idUsuario;
	@OneToOne
	private TipoMarcacao tipo;
	private LocalDate dia;
	private LocalTime hora;
	private String longitude;
	private String latitude;
	
	public Marcacao() {
		
	}
	
	public Marcacao(Turno idTurno, Usuario idUsuario, LocalDate dia, LocalTime hora, TipoMarcacao tipo, String longitude, String latitude) {
		this.idTurno = idTurno;
		this.idUsuario = idUsuario;
		this.dia = dia;
		this.hora = hora;
		this.tipo = tipo;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TipoMarcacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMarcacao tipo) {
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
	
	
}
