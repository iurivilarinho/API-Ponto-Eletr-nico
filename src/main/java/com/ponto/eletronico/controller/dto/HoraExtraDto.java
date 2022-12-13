package com.ponto.eletronico.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


import com.ponto.eletronico.models.HoraExtra;
import com.ponto.eletronico.models.Usuario;

public class HoraExtraDto {
	private Long id;
	private LocalDate dia;
	private LocalTime hora;
	private Usuario idUsuario;
	
	public HoraExtraDto(HoraExtra horaextra) {
		this.id = horaextra.getId();
		this.dia = horaextra.getDia();
		this.hora = horaextra.getHora();
		this.idUsuario = horaextra.getIdUsuario();
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




public static List<HoraExtraDto> converter(List<HoraExtra> horaextra) {
		
		return horaextra.stream().map(HoraExtraDto::new).collect(Collectors.toList());
	}
}


