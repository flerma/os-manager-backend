package br.com.vetrotec.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Embeddable
public class AuditoriaUsuario {
	
	@NotNull
	@Column(name="data_inclusao")
	private LocalDate dataInclusao;
	
	@NotNull
	@Column(name="usuario_inclusao")
	private Integer usuarioInclusao;
	
	@Column(name="data_alteracao")
	private LocalDate dataAlteracao;
	
	@Column(name="usuario_alteracao")
	private Integer usuarioAltercao;
	
}
