package com.ponto.eletronico.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ponto.eletronico.models.Marcacao;

public interface MarcacaoRepository extends JpaRepository<Marcacao, Long> {

	
	Marcacao findAllByDia(LocalDate dia);

	Optional<Marcacao> findByDia(LocalDate dia);
	
}
