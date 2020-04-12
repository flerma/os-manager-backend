package br.com.vetrotec.api.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrcamentoFilter {
	
	private Long codigoTipoServico;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAgendamentoDe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAgendamentoAte;
			

}
