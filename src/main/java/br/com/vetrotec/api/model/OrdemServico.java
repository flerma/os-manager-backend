package br.com.vetrotec.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo")
	private long codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_orcamento", insertable=false, updatable=false, referencedColumnName="codigo")
	private Orcamento orcamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_status_ordem_servico", insertable=false, updatable=false, referencedColumnName="codigo")
	private StatusOrdemServico status;
	
	@NotNull
	@Column(name = "data_agendamento")
	private LocalDate dataAgendamento;
	
	@NotNull
	@Column(name = "data_execucao")
	private LocalDate dataExecucao;
	
	@Embedded
	private AuditoriaUsuario auditoriaUsuario;

}
