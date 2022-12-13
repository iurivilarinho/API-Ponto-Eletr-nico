package com.ponto.eletronico.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ponto.eletronico.models.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String cpf;
	private byte[] img;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.telefone = usuario.getTelefone();
		this.cpf = usuario.getCpf();
		this.img = usuario.getImg();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public byte[] getImg() {
		return img;
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuario){
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}  
}
