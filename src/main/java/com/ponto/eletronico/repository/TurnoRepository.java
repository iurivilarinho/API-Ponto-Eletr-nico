package com.ponto.eletronico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ponto.eletronico.models.Turno;


public interface TurnoRepository extends JpaRepository<Turno, Long> {

	List<Turno> findByDescricao(String descricao);

}
