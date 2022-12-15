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

import com.ponto.eletronico.controller.dto.EscalaDto;
import com.ponto.eletronico.form.EscalaForm;
import com.ponto.eletronico.models.Escala;
import com.ponto.eletronico.repository.EscalaRepository;


@RestController
@RequestMapping("/escala")
public class EscalaController {

	@Autowired
	private EscalaRepository escalaRepository;


	
	@GetMapping
	@Transactional
	public List<EscalaDto> lista(){
		List<Escala> escala = escalaRepository.findAll();
		return EscalaDto.converter(escala);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EscalaDto> cadastrar(@RequestBody @Valid EscalaForm form, UriComponentsBuilder uriBuilder) {
		Escala escala = form.formulario();
		escalaRepository.save(escala);
		
		URI uri = uriBuilder.path("/escala/{id}").buildAndExpand(escala.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new EscalaDto(escala));
	}
	
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity <EscalaDto> detalhar(@PathVariable Long id) {
		Optional <Escala> escala = escalaRepository.findById(id);
		if(escala.isPresent()) {
			return ResponseEntity.ok(new EscalaDto(escala.get()));
		}
		
		return ResponseEntity.notFound().build();
		}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EscalaDto> atualizar(@PathVariable Long id, @RequestBody @Valid EscalaForm form) {
		Optional <Escala> optional = escalaRepository.findById(id);
		if(optional.isPresent()) {  
			Escala escala = form.atualizar(id, escalaRepository);
			return ResponseEntity.ok (new EscalaDto(escala));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional <Escala> optional = escalaRepository.findById(id);
		if(optional.isPresent()) {
			
			escalaRepository.deleteById(id);
		
		return ResponseEntity.ok ().build();
			
		}
		
		return ResponseEntity.notFound().build();
		}
}
