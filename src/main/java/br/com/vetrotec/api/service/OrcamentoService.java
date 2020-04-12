package br.com.vetrotec.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.vetrotec.api.model.Orcamento;
import br.com.vetrotec.api.repository.OrcamentoRepository;
import br.com.vetrotec.api.repository.filter.OrcamentoFilter;
import br.com.vetrotec.api.repository.projection.ResumoOrcamento;

@Service
public class OrcamentoService {
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	public Page<Orcamento> pesquisar(OrcamentoFilter orcamentoFilter, Pageable pageable) {
		return orcamentoRepository.filtrar(orcamentoFilter, pageable);
	}
	
	public Page<ResumoOrcamento> resumir(OrcamentoFilter orcamentoFilter, Pageable pageable) {
		return orcamentoRepository.resumir(orcamentoFilter, pageable);
	}
	
	public Orcamento buscarPorCodigo(Long codigo) {
		return orcamentoRepository.findOne(codigo);
	}
	
	public Orcamento incluir(Orcamento orcamento) {
		return orcamentoRepository.save(orcamento);
	}
	
	public Orcamento atualizar(Orcamento orcamento) {
		return orcamentoRepository.save(orcamento);
	}
	
	public void excluir(Long codigo) {
		orcamentoRepository.delete(codigo);
	}
	
}
