package br.com.vetrotec.api.repository.orcamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.vetrotec.api.model.Orcamento;
import br.com.vetrotec.api.repository.filter.OrcamentoFilter;
import br.com.vetrotec.api.repository.projection.ResumoOrcamento;

public interface OrcamentoRepositoryQuery {
	
	public Page<Orcamento> filtrar(OrcamentoFilter orcamentoFilter, Pageable pageable);
	public Page<ResumoOrcamento> resumir(OrcamentoFilter orcamentoFilter, Pageable pageable);
	
}
