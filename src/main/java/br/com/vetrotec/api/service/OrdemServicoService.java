package br.com.vetrotec.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vetrotec.api.model.OrdemServico;
import br.com.vetrotec.api.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public List<OrdemServico> pesquisar() {
		return ordemServicoRepository.findAll();
	}
	
	public OrdemServico buscarPorCodigo(Long codigo) {
		return ordemServicoRepository.findOne(codigo);
	}
	
	public OrdemServico incluir(OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}
	
	public OrdemServico atualizar(OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}
	
	public void excluir(Long codigo) {
		ordemServicoRepository.delete(codigo);
	}
	
}
