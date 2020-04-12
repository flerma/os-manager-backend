package br.com.vetrotec.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vetrotec.api.model.OrdemServico;
import br.com.vetrotec.api.service.OrdemServicoService;

@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoResource {
	
	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ORDEM_SERVICO') and #oauth2.hasScope('read')")
	public ResponseEntity<List<OrdemServico>> pesquisar() {
		return ResponseEntity.ok().body(ordemServicoService.pesquisar());
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ORDEM_SERVICO') and #oauth2.hasScope('read')")
	public ResponseEntity<OrdemServico> buscarPeloCodigo(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(ordemServicoService.buscarPorCodigo(codigo));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ORDEM_SERVICO') and #oauth2.hasScope('write')")
	public ResponseEntity<OrdemServico> incluir(@Valid @RequestBody OrdemServico ordemServico, HttpServletResponse response) {
		
		OrdemServico ordemServicoSalvo = ordemServicoService.incluir(ordemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(ordemServicoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(ordemServicoSalvo);
	}
	
	@PutMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ORDEM_SERVICO') and #oauth2.hasScope('write')")
	public ResponseEntity<OrdemServico> atualizar(@Valid @RequestBody OrdemServico ordemServico) {
		OrdemServico ordemServicoSalvo = ordemServicoService.atualizar(ordemServico);
		return ResponseEntity.ok().body(ordemServicoSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ORDEM_SERVICO') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long codigo) {
		ordemServicoService.excluir(codigo);
	}
	

}
