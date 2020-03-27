package br.com.vetrotec.api.model;

import java.math.BigDecimal;
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
@Table(name = "ORCAMENTO")
public class Orcamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo")
	private long codigo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_cliente", insertable=false, updatable=false, referencedColumnName="codigo")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_tipo_servico", insertable=false, updatable=false, referencedColumnName="codigo")
	private TipoServico tipoServico;
	
	@NotNull
	@Column(name = "data_agendamento")
	private LocalDate dataAgendamento;
	
	@NotNull
	@Column(name = "data_execucao")
	private LocalDate dataExecucao;
	
	@NotNull
	@Column(name="valor")
	private BigDecimal valor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_status_orcamento", insertable=false, updatable=false, referencedColumnName="codigo")
	private StatusOrcamento status;
	
	@Embedded
	private AuditoriaUsuario auditoriaUsuario;
	
}
