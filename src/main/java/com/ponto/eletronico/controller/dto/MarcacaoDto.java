package com.ponto.eletronico.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ponto.eletronico.models.Marcacao;
import com.ponto.eletronico.models.TipoMarcacao;
import com.ponto.eletronico.models.Turno;
import com.ponto.eletronico.models.Usuario;

public class MarcacaoDto {

	private Long id;
	private Turno idTurno;
	private Usuario idUsuario;
	private TipoMarcacao tipo;
	private LocalDate dia;
	private LocalTime hora;
	private String longitude;
	private String latitude;
	
	public MarcacaoDto(Marcacao marcacao) {
		this.id = marcacao.getId();
		this.idTurno = marcacao.getIdTurno();
		this.idUsuario = marcacao.getIdUsuario();
		this.tipo = marcacao.getTipo();
		this.dia = marcacao.getDia();
		this.hora = marcacao.getHora();
		this.longitude = marcacao.getLongitude();
		this.latitude = marcacao.getLatitude();
	}

	public Long getId() {
		return id;
	}

	public Turno getIdTurno() {
		return idTurno;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public TipoMarcacao getTipo() {
		return tipo;
	}

	public LocalDate getDia() {
		return dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}
	
public static List<MarcacaoDto> converter(List<Marcacao> marcacao) {
		
		return marcacao.stream().map(MarcacaoDto::new).collect(Collectors.toList());
	}
}
