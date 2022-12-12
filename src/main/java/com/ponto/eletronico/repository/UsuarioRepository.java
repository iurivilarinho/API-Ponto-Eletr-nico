package com.ponto.eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ponto.eletronico.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
