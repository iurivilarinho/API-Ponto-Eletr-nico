package com.ponto.eletronico.controller.dto;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ponto.eletronico.models.TipoMarcacao;

public class TipoMarcacaoDto {
	
	private Long id;
	private int cod;
	private String desc;
	private LocalTime max;
	private LocalTime min;

	public TipoMarcacaoDto(TipoMarcacao tipo) {
		this.id = tipo.getId();
		this.cod = tipo.getCod();
		this.desc = tipo.getDesc();
		this.max = tipo.getMax();
		this.min = tipo.getMin();
	}

	public Long getId() {
		return id;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public LocalTime getMax() {
		return max;
	}

	public LocalTime getMin() {
		return min;
	}
	
	public static List<TipoMarcacaoDto> converter(List<TipoMarcacao> tipo){
		return tipo.stream().map(TipoMarcacaoDto::new).collect(Collectors.toList());
	}
}
