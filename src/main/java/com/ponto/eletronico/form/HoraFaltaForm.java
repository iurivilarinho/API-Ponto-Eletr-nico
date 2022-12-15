package com.ponto.eletronico.form;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ponto.eletronico.models.HoraFalta;
import com.ponto.eletronico.models.Usuario;
import com.ponto.eletronico.repository.HoraFaltaRepository;
import com.ponto.eletronico.repository.UsuarioRepository;

public class HoraFaltaForm {

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



	public HoraFalta formulario(UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
		HoraFalta horafalta = new HoraFalta();
			
		horafalta.setIdUsuario(usuario);
		horafalta.setDia(dia);
		horafalta.setHora(hora);
		
		return horafalta;
	}
	
	public HoraFalta atualizar(Long id, HoraFaltaRepository faltaRepository, UsuarioRepository usuarioRepository) {
		
		Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
		HoraFalta horafalta = faltaRepository.getReferenceById(id);
			
		horafalta.setIdUsuario(usuario);
		horafalta.setDia(dia);
		horafalta.setHora(hora);
		
		return horafalta;
	}
}
