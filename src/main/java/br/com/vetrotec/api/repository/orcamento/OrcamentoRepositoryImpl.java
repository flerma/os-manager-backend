package br.com.vetrotec.api.repository.orcamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.vetrotec.api.model.Orcamento;
import br.com.vetrotec.api.repository.filter.OrcamentoFilter;
import br.com.vetrotec.api.repository.projection.ResumoOrcamento;

public class OrcamentoRepositoryImpl implements OrcamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Page<Orcamento> filtrar(OrcamentoFilter orcamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Orcamento> criteria = builder.createQuery(Orcamento.class);
		Root<Orcamento> rootOrcamento = criteria.from(Orcamento.class);
		
		Predicate[] predicates = buscarFiltros(orcamentoFilter, builder, rootOrcamento);
		criteria.where(predicates);
		
		TypedQuery<Orcamento> query = entityManager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(orcamentoFilter));
	}
	

	@Override
	public Page<ResumoOrcamento> resumir(OrcamentoFilter orcamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ResumoOrcamento> criteria = builder.createQuery(ResumoOrcamento.class);
		Root<Orcamento> root = criteria.from(Orcamento.class);
		
		criteria.select(builder.construct(ResumoOrcamento.class
				, root.get("codigo")
				, root.get("cliente").get("nome")
				, root.get("dataAgendamento")
				, root.get("tipoServico").get("descricao")
				, root.get("valor")
				, root.get("status").get("descricao")));
		
		Predicate[] predicates = buscarFiltros(orcamentoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoOrcamento> query = entityManager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(orcamentoFilter));
	}

	private Predicate[] buscarFiltros(OrcamentoFilter orcamentoFilter, CriteriaBuilder builder,
			Root<Orcamento> rootOrcamento) {
		List<Predicate> filtros = new ArrayList<>();
		
		if (!StringUtils.isEmpty(orcamentoFilter.getCodigoTipoServico())) {
			filtros.add(
					builder.equal(rootOrcamento.get("tipoServico").get("codigo"), orcamentoFilter.getCodigoTipoServico()));
		}
		
		if (orcamentoFilter.getDataAgendamentoDe() != null) {
			filtros.add(
					builder.greaterThanOrEqualTo(rootOrcamento.get("dataAgendamento"), orcamentoFilter.getDataAgendamentoDe()));
		}
		
		if (orcamentoFilter.getDataAgendamentoAte() != null) {
			filtros.add(
					builder.lessThanOrEqualTo(rootOrcamento.get("dataAgendamento"), orcamentoFilter.getDataAgendamentoAte()));
		}
		
		return filtros.toArray(new Predicate[filtros.size()]);
		
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(OrcamentoFilter orcamentoFilter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Orcamento> root = criteria.from(Orcamento.class);
		
		Predicate[] predicates = buscarFiltros(orcamentoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return entityManager.createQuery(criteria).getSingleResult();
	}

	

}
