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

import br.com.vetrotec.api.model.Orcamento;
import br.com.vetrotec.api.service.OrcamentoService;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoResource {
	
	
	@Autowired
	private OrcamentoService orcamentoService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ORCAMENTO') and #oauth2.hasScope('read')")
	public ResponseEntity<List<Orcamento>> pesquisar() {
		return ResponseEntity.ok().body(orcamentoService.pesquisar());
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ORCAMENTO') and #oauth2.hasScope('read')")
	public ResponseEntity<Orcamento> buscarPeloCodigo(@PathVariable Long codigo) {
		return ResponseEntity.ok().body(orcamentoService.buscarPorCodigo(codigo));
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ORCAMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Orcamento> incluir(@Valid @RequestBody Orcamento orcamento, HttpServletResponse response) {
		
		Orcamento orcamentoSalvo = orcamentoService.incluir(orcamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(orcamentoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(orcamentoSalvo);
	}
	
	@PutMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ORCAMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<Orcamento> atualizar(@Valid @RequestBody Orcamento orcamento) {
		Orcamento orcamentoSalvo = orcamentoService.atualizar(orcamento);
		return ResponseEntity.ok().body(orcamentoSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ORCAMENTO') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Long codigo) {
		orcamentoService.excluir(codigo);
	}
	

}
