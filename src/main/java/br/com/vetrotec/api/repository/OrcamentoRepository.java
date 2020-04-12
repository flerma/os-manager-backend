package br.com.vetrotec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vetrotec.api.model.Orcamento;
import br.com.vetrotec.api.repository.orcamento.OrcamentoRepositoryQuery;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long>, OrcamentoRepositoryQuery {

}
