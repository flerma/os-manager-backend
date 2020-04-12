package br.com.vetrotec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vetrotec.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
}
