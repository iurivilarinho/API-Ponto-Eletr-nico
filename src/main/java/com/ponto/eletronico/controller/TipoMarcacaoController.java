package com.ponto.eletronico.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.ponto.eletronico.controller.dto.TipoMarcacaoDto;
import com.ponto.eletronico.form.TipoMarcacaoForm;
import com.ponto.eletronico.models.TipoMarcacao;
import com.ponto.eletronico.repository.TipoMarcacaoRepository;

@RestController
@RequestMapping("/tipomarcacao")
public class TipoMarcacaoController {

	@Autowired
	private TipoMarcacaoRepository tipoRepository;


	
	@GetMapping
	@Transactional
	public List<TipoMarcacaoDto> lista(){
		List<TipoMarcacao> tipo = tipoRepository.findAll();
		return TipoMarcacaoDto.converter(tipo);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TipoMarcacaoDto> cadastrar(@RequestBody @Valid TipoMarcacaoForm form, UriComponentsBuilder uriBuilder) {
		TipoMarcacao tipo = form.formulario();
		tipoRepository.save(tipo);
		
		URI uri = uriBuilder.path("/tipomarcacao/{id}").buildAndExpand(tipo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TipoMarcacaoDto(tipo));
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity <TipoMarcacaoDto> detalhar(@PathVariable Long id) {
		Optional <TipoMarcacao> tipo = tipoRepository.findById(id);
		if(tipo.isPresent()) {
			return ResponseEntity.ok(new TipoMarcacaoDto(tipo.get()));
		}
		
		return ResponseEntity.notFound().build();
		}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TipoMarcacaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid TipoMarcacaoForm form) {
		Optional <TipoMarcacao> optional = tipoRepository.findById(id);
		if(optional.isPresent()) {  
			TipoMarcacao tipo = form.atualizar(id, tipoRepository);
			return ResponseEntity.ok (new TipoMarcacaoDto(tipo));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional <TipoMarcacao> optional = tipoRepository.findById(id);
		if(optional.isPresent()) {
			
			tipoRepository.deleteById(id);
		
		return ResponseEntity.ok ().build();
			
		}
		
		return ResponseEntity.notFound().build();
		}
}
