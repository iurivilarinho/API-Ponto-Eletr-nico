package com.ponto.eletronico.services;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ponto.eletronico.form.MarcacaoForm;
import com.ponto.eletronico.models.HoraExtra;
import com.ponto.eletronico.models.HoraFalta;
import com.ponto.eletronico.models.Marcacao;
import com.ponto.eletronico.models.Turno;
import com.ponto.eletronico.models.Usuario;
import com.ponto.eletronico.repository.HoraExtraRepository;
import com.ponto.eletronico.repository.HoraFaltaRepository;
import com.ponto.eletronico.repository.MarcacaoRepository;
import com.ponto.eletronico.repository.TurnoRepository;
import com.ponto.eletronico.repository.UsuarioRepository;

@Component
@Service
public class MarcacaoService {

	private static Logger logger = LoggerFactory.getLogger(MarcacaoService.class);

	public Marcacao entrada(MarcacaoForm form, MarcacaoRepository marcacaoRepository) {
		List<Marcacao> marcacaoTotais = marcacaoRepository.findAll();
		Marcacao entrada = new Marcacao();

		for (Marcacao m : marcacaoTotais) {
			if (m.getDia().compareTo(form.getDia()) == 0 && m.getTipo().getCod() == /* parametro */1) {
				entrada = m;
				return entrada;
			}
		}
		return null;
	}

	public void gerarHoraExtra(MarcacaoForm form, TurnoRepository turnoRepository,
			MarcacaoRepository marcacaoRepository, HoraExtraRepository extraRepository,
			HoraFaltaRepository faltaRepository, UsuarioRepository usuarioRepository) {

		Optional<Usuario> usuario = usuarioRepository.findById(form.getIdUsuario());
		Optional<Turno> turno = turnoRepository.findById(form.getIdTurno());

		Marcacao entrada = entrada(form, marcacaoRepository);
		if (entrada != null) {
			if (form.getTipo() == /* parametro */2) {
				
				LocalTime DiaReal = form.getHora()
						.minusHours(entrada.getHora().getHour())
						.minusMinutes(entrada.getHora().getMinute());
				logger.info("Hora Dia: {} ", DiaReal);
				
				LocalTime extra = DiaReal.minusHours(turno.get()
						.getIdEscala()
						.getHrsDia()
						.getHour())
						.minusMinutes(turno.get().getIdEscala().getHrsDia().getMinute());
				logger.info("Hora Extra: {} ", extra);
				
				LocalTime falta = turno.get()
						.getIdEscala()
						.getHrsDia()
						.minusHours(DiaReal.getHour())
						.minusMinutes(DiaReal.getMinute());
				logger.info("Hora falta: {} ", falta);

				if (DiaReal.isAfter(turno.get().getIdEscala().getHrsDia())) {
 
					HoraExtra horaextra = new HoraExtra();
					horaextra.setDia(form.getDia());
					horaextra.setIdUsuario(usuario.get());
					horaextra.setHora(extra);

					extraRepository.save(horaextra);

				} else if (DiaReal.isBefore(turno.get().getIdEscala().getHrsDia())) {
					HoraFalta horafalta = new HoraFalta();
					horafalta.setDia(form.getDia());
					horafalta.setIdUsuario(usuario.get());
					horafalta.setHora(falta);

					faltaRepository.save(horafalta);
				}

			}
		} else {
			logger.info("nulo");
		}

	}

}
