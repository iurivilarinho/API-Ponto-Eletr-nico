package com.ponto.eletronico.form;

import java.time.LocalTime;

import com.ponto.eletronico.models.TipoMarcacao;

public class TipoMarcacaoForm {

	private int cod;
	private String desc;
	private LocalTime max;
	private LocalTime min;
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LocalTime getMax() {
		return max;
	}
	public void setMax(LocalTime max) {
		this.max = max;
	}
	public LocalTime getMin() {
		return min;
	}
	public void setMin(LocalTime min) {
		this.min = min;
	}
	
	public TipoMarcacao formulario() {
		TipoMarcacao tipomarcacao = new TipoMarcacao();
		
		tipomarcacao.setCod(cod);
		tipomarcacao.setDesc(desc);
		tipomarcacao.setMax(max);
		tipomarcacao.setMin(min);
		
		return tipomarcacao;
	}
}
