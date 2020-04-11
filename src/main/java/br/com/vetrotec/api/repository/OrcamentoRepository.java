package br.com.vetrotec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vetrotec.api.model.Orcamento;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

}
