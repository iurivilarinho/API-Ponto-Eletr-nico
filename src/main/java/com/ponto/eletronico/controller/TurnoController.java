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

import com.ponto.eletronico.controller.dto.TurnoDto;
import com.ponto.eletronico.form.TurnoForm;
import com.ponto.eletronico.models.Turno;
import com.ponto.eletronico.repository.EscalaRepository;
import com.ponto.eletronico.repository.TurnoRepository;

@RestController
@RequestMapping("/turno")
public class TurnoController {

	@Autowired
	private TurnoRepository turnoRepository;
	@Autowired
	private EscalaRepository escalaRepository;
	
	
	@GetMapping
	@Transactional
	public List<TurnoDto> lista(String descricao) {
		
		if(descricao == null) {
			List<Turno> turno = turnoRepository.findAll();
			return TurnoDto.converter(turno);
			
		}else {
			
			List<Turno> turno = turnoRepository.findByDescricao(descricao);/*Metodo criado detro de topicoRepository para busca somente um atributo de uma entidade(nesse caso especifico busca o nome dentro de uma entidade que se relaciona com topico findByCursoNome  Curso= entidade Nome = atributo de curso)*/
			return TurnoDto.converter(turno);
		}
	}
		
		@PostMapping
		@Transactional
		public ResponseEntity<TurnoDto> cadastrar(@RequestBody @Valid TurnoForm form, UriComponentsBuilder uriBuilder ) {
			
			Turno turno = form.formulario(escalaRepository);
			turnoRepository.save(turno);
			
			URI uri = uriBuilder.path("/turno/{id}").buildAndExpand(turno.getId()).toUri();
			return ResponseEntity.created(uri).body(new TurnoDto(turno));
		}
		
		@GetMapping("/{id}")
		@Transactional
		public ResponseEntity <TurnoDto> detalhar(@PathVariable Long id) {
			Optional <Turno> turno = turnoRepository.findById(id);
			if(turno.isPresent()) {
				return ResponseEntity.ok(new TurnoDto(turno.get()));
			}
			
			return ResponseEntity.notFound().build();
			}
		
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<TurnoDto> atualizar(@PathVariable Long id, @RequestBody @Valid TurnoForm form) {
			Optional <Turno> optional = turnoRepository.findById(id);
			if(optional.isPresent()) {
				Turno turno = form.atualizar(id, escalaRepository, turnoRepository);
				return ResponseEntity.ok (new TurnoDto(turno));
			}
			
			return ResponseEntity.notFound().build();
		}
			
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional <Turno> optional = turnoRepository.findById(id);
			if(optional.isPresent()) {
				
				turnoRepository.deleteById(id);
			
			return ResponseEntity.ok ().build();
				
			}
			
			return ResponseEntity.notFound().build();
			}
}
