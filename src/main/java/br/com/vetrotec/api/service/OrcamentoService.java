package br.com.vetrotec.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vetrotec.api.model.Orcamento;
import br.com.vetrotec.api.repository.OrcamentoRepository;

@Service
public class OrcamentoService {
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	public List<Orcamento> pesquisar() {
		return orcamentoRepository.findAll();
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
