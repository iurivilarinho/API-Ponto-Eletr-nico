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

import com.ponto.eletronico.controller.dto.PeriodoDto;
import com.ponto.eletronico.form.PeriodoForm;
import com.ponto.eletronico.models.Periodo;
import com.ponto.eletronico.repository.PeriodoRepository;
import com.ponto.eletronico.repository.TurnoRepository;
import com.ponto.eletronico.repository.UsuarioRepository;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {

	
		
		@Autowired
		private PeriodoRepository periodoRepository;
		@Autowired
		private UsuarioRepository usuarioRepository;
		@Autowired
		private TurnoRepository turnoRepository;

		
		@GetMapping
		@Transactional
		public List<PeriodoDto> lista(){
			List<Periodo> marcacao = periodoRepository.findAll();
			return PeriodoDto.converter(marcacao);
		}
		
		@PostMapping
		@Transactional
		public ResponseEntity<PeriodoDto> cadastrar(@RequestBody @Valid PeriodoForm form, UriComponentsBuilder uriBuilder) {
			Periodo periodo = form.formulario(usuarioRepository, turnoRepository);
			periodoRepository.save(periodo);
			
			URI uri = uriBuilder.path("/periodo/{id}").buildAndExpand(periodo.getId()).toUri();
			
			return ResponseEntity.created(uri).body(new PeriodoDto(periodo));
		}
		
		@GetMapping("/{id}")
		@Transactional
		public ResponseEntity <PeriodoDto> detalhar(@PathVariable Long id) {
			Optional <Periodo> periodo = periodoRepository.findById(id);
			if(periodo.isPresent()) {
				return ResponseEntity.ok(new PeriodoDto(periodo.get()));
			}
			
			return ResponseEntity.notFound().build();
			}
		
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<PeriodoDto> atualizar(@PathVariable Long id, @RequestBody @Valid PeriodoForm form) {
			Optional <Periodo> optional = periodoRepository.findById(id);
			if(optional.isPresent()) {  
				Periodo periodo = form.atualizar(id, periodoRepository,usuarioRepository, turnoRepository);
				return ResponseEntity.ok (new PeriodoDto(periodo));
			}
			
			return ResponseEntity.notFound().build();
		}
		
		
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional <Periodo> optional = periodoRepository.findById(id);
			if(optional.isPresent()) {
				
				periodoRepository.deleteById(id);
			
			return ResponseEntity.ok ().build();
				
			}
			
			return ResponseEntity.notFound().build();
			}

	}
	
