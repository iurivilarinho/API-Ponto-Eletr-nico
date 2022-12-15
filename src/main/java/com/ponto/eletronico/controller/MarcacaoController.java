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

import com.ponto.eletronico.controller.dto.MarcacaoDto;
import com.ponto.eletronico.form.MarcacaoForm;
import com.ponto.eletronico.models.Marcacao;
import com.ponto.eletronico.repository.MarcacaoRepository;
import com.ponto.eletronico.repository.TipoMarcacaoRepository;
import com.ponto.eletronico.repository.TurnoRepository;
import com.ponto.eletronico.repository.UsuarioRepository;


@RestController
@RequestMapping("/marcacao")
public class MarcacaoController {
	
	@Autowired
	private MarcacaoRepository marcacaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TurnoRepository turnoRepository;
	@Autowired
	private TipoMarcacaoRepository tipoRepository;
	
	@GetMapping
	@Transactional
	public List<MarcacaoDto> lista(){
		List<Marcacao> marcacao = marcacaoRepository.findAll();
		return MarcacaoDto.converter(marcacao);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<MarcacaoDto> cadastrar(@RequestBody @Valid MarcacaoForm form, UriComponentsBuilder uriBuilder) {
		Marcacao marcacao = form.formulario(turnoRepository, usuarioRepository, tipoRepository);
		marcacaoRepository.save(marcacao);
		
		URI uri = uriBuilder.path("/marcacao/{id}").buildAndExpand(marcacao.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new MarcacaoDto(marcacao));
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity <MarcacaoDto> detalhar(@PathVariable Long id) {
		Optional <Marcacao> marcacao = marcacaoRepository.findById(id);
		if(marcacao.isPresent()) {
			return ResponseEntity.ok(new MarcacaoDto(marcacao.get()));
		}
		
		return ResponseEntity.notFound().build();
		}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<MarcacaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid MarcacaoForm form) {
		Optional <Marcacao> optional = marcacaoRepository.findById(id);
		if(optional.isPresent()) {  
			Marcacao marcacao = form.atualizar(id, marcacaoRepository, turnoRepository, usuarioRepository, tipoRepository );
			return ResponseEntity.ok (new MarcacaoDto(marcacao));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional <Marcacao> optional = marcacaoRepository.findById(id);
		if(optional.isPresent()) {
			
			marcacaoRepository.deleteById(id);
		
		return ResponseEntity.ok ().build();
			
		}
		
		return ResponseEntity.notFound().build();
		}

}
