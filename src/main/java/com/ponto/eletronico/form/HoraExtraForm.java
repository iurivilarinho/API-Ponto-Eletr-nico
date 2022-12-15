package com.ponto.eletronico.form;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ponto.eletronico.models.HoraExtra;
import com.ponto.eletronico.models.Usuario;
import com.ponto.eletronico.repository.HoraExtraRepository;
import com.ponto.eletronico.repository.UsuarioRepository;


public class HoraExtraForm {
	
	private LocalDate dia;
	private LocalTime hora;
	private Long idUsuario;
	

	
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



	public Long getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}



	public HoraExtra formulario(UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
		HoraExtra horaextra = new HoraExtra();
			
		horaextra.setIdUsuario(usuario);
		horaextra.setDia(dia);
		horaextra.setHora(hora);
		
		return horaextra;
	}
	
	public HoraExtra atualizar(Long id, HoraExtraRepository extraRepository, UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
		HoraExtra horaextra = extraRepository.getReferenceById(id);
			
		horaextra.setIdUsuario(usuario);
		horaextra.setDia(dia);
		horaextra.setHora(hora);
		
		return horaextra;
	}

}
