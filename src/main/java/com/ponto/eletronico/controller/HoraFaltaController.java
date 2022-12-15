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

import com.ponto.eletronico.controller.dto.HoraFaltaDto;
import com.ponto.eletronico.form.HoraFaltaForm;
import com.ponto.eletronico.models.HoraFalta;
import com.ponto.eletronico.repository.HoraFaltaRepository;
import com.ponto.eletronico.repository.UsuarioRepository;

@RestController
@RequestMapping("/horafalta")
public class HoraFaltaController {

	
		
		@Autowired
		private  HoraFaltaRepository faltaRepository;
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		
		@GetMapping
		@Transactional
		public List<HoraFaltaDto> lista(){
			List<HoraFalta> horaextra = faltaRepository.findAll();
			return HoraFaltaDto.converter(horaextra);
		}
		
		@PostMapping
		@Transactional
		public ResponseEntity<HoraFaltaDto> cadastrar(@RequestBody @Valid HoraFaltaForm form, UriComponentsBuilder uriBuilder) {
			HoraFalta horafalta = form.formulario(usuarioRepository);
			faltaRepository.save(horafalta);
			
			URI uri = uriBuilder.path("/marcacao/{id}").buildAndExpand(horafalta.getId()).toUri();
			
			return ResponseEntity.created(uri).body(new HoraFaltaDto(horafalta));
		}
		
		@GetMapping("/{id}")
		@Transactional
		public ResponseEntity <HoraFaltaDto> detalhar(@PathVariable Long id) {
			Optional <HoraFalta> horafalta = faltaRepository.findById(id);
			if(horafalta.isPresent()) {
				return ResponseEntity.ok(new HoraFaltaDto(horafalta.get()));
			}
			
			return ResponseEntity.notFound().build();
			}
		
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<HoraFaltaDto> atualizar(@PathVariable Long id, @RequestBody @Valid HoraFaltaForm form) {
			Optional <HoraFalta> optional = faltaRepository.findById(id);
			if(optional.isPresent()) {  
				HoraFalta horafalta = form.atualizar(id, faltaRepository, usuarioRepository);
				return ResponseEntity.ok(new HoraFaltaDto(horafalta));
			}
			
			return ResponseEntity.notFound().build();
		}
		
		
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional <HoraFalta> optional = faltaRepository.findById(id);
			if(optional.isPresent()) {
				
				faltaRepository.deleteById(id);
			
			return ResponseEntity.ok ().build();
				
			}
			
			return ResponseEntity.notFound().build();
			}

	}



