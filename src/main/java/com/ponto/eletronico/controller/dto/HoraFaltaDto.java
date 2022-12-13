package com.ponto.eletronico.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


import com.ponto.eletronico.models.HoraFalta;
import com.ponto.eletronico.models.Usuario;

public class HoraFaltaDto {
	private Long id;
	private LocalDate dia;
	private LocalTime hora;
	private Usuario idUsuario;
	
	public HoraFaltaDto(HoraFalta horafalta) {
		this.id = horafalta.getId();
		this.dia = horafalta.getDia();
		this.hora = horafalta.getHora();
		this.idUsuario = horafalta.getIdUsuario();
	}
	
	
	public Long getId() {
		return id;
	}




	public LocalDate getDia() {
		return dia;
	}




	public LocalTime getHora() {
		return hora;
	}




	public Usuario getIdUsuario() {
		return idUsuario;
	}




public static List<HoraFaltaDto> converter(List<HoraFalta> horafalta) {
		
		return horafalta.stream().map(HoraFaltaDto::new).collect(Collectors.toList());
	}
}

