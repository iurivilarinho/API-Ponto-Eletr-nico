package com.ponto.eletronico.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ponto.eletronico.models.TipoMarcacao;

public interface TipoMarcacaoRepository extends JpaRepository <TipoMarcacao, Long> {

	Optional<TipoMarcacao> findByDescricao(String descricao);

}
