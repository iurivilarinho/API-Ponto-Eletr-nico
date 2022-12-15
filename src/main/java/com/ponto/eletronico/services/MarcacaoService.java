package com.ponto.eletronico.services;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ponto.eletronico.models.Marcacao;
import com.ponto.eletronico.models.TipoMarcacao;

import com.ponto.eletronico.repository.TipoMarcacaoRepository;

@Service
public class MarcacaoService {
	
	
	/*public Marcacao tratativa(TipoMarcacaoRepository tipo) {
		Marcacao marcacao = new Marcacao();
		Optional<TipoRegistro> tipomarcacao = tipo.findByDesc(marcacao.getTipo().getDesc());
		
		if(tipomarcacao.isPresent()) {
			marcacao.setTipo(marcacao.getTipo());
		}else {
			
			//esse tipo não existe
			
		}
		
		return marcacao;
	}*/
}
