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

import com.ponto.eletronico.controller.dto.HoraExtraDto;
import com.ponto.eletronico.form.HoraExtraForm;
import com.ponto.eletronico.models.HoraExtra;
import com.ponto.eletronico.repository.HoraExtraRepository;
import com.ponto.eletronico.repository.UsuarioRepository;

@RestController
@RequestMapping("/horaextra")
public class HoraExtraController {

	
		
		@Autowired
		private HoraExtraRepository extraRepository;
		@Autowired
		private UsuarioRepository usuarioRepository;
		
		
		@GetMapping
		@Transactional
		public List<HoraExtraDto> lista(){
			List<HoraExtra> horaextra = extraRepository.findAll();
			return HoraExtraDto.converter(horaextra);
		}
		
		@PostMapping
		@Transactional
		public ResponseEntity<HoraExtraDto> cadastrar(@RequestBody @Valid HoraExtraForm form, UriComponentsBuilder uriBuilder) {
			HoraExtra horaextra = form.formulario(usuarioRepository);
			extraRepository.save(horaextra);
			
			URI uri = uriBuilder.path("/horaextra/{id}").buildAndExpand(horaextra.getId()).toUri();
			
			return ResponseEntity.created(uri).body(new HoraExtraDto(horaextra));
		}
		
		@GetMapping("/{id}")
		@Transactional
		public ResponseEntity <HoraExtraDto> detalhar(@PathVariable Long id) {
			Optional <HoraExtra> horaextra = extraRepository.findById(id);
			if(horaextra.isPresent()) {
				return ResponseEntity.ok(new HoraExtraDto(horaextra.get()));
			}
			
			return ResponseEntity.notFound().build();
			}
		
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<HoraExtraDto> atualizar(@PathVariable Long id, @RequestBody @Valid HoraExtraForm form) {
			Optional <HoraExtra> optional = extraRepository.findById(id);
			if(optional.isPresent()) {  
				HoraExtra horaextra = form.atualizar(id, extraRepository, usuarioRepository);
				return ResponseEntity.ok(new HoraExtraDto(horaextra));
			}
			
			return ResponseEntity.notFound().build();
		}
		
		
		@DeleteMapping("/{id}")
		@Transactional
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional <HoraExtra> optional = extraRepository.findById(id);
			if(optional.isPresent()) {
				
				extraRepository.deleteById(id);
			
			return ResponseEntity.ok ().build();
				
			}
			
			return ResponseEntity.notFound().build();
			}

	}


