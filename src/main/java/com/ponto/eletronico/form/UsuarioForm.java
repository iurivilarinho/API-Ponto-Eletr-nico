package com.ponto.eletronico.form;


import com.ponto.eletronico.models.Usuario;
import com.ponto.eletronico.repository.UsuarioRepository;

public class UsuarioForm {

	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String cpf;
	private byte[] img;
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	
	public Usuario formulario() {
		Usuario usuario = new Usuario();
		
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setImg(img);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);
		
		return usuario;
	}
	
	public Usuario atualizar(Long id,UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getReferenceById(id);
		
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setImg(img);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setTelefone(telefone);
		
		return usuario;
	}
	
	
}
