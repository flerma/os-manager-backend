package br.com.vetrotec.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "STATUS_ORCAMENTO")
public class StatusOrcamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODIGO")
	private long codigo;
	
	@NotNull
	@Column(name="DESCRICAO")
	private String descricao;
	
}
