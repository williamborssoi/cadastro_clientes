package br.edu.unoesc.ads.clientes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.ads.clientes.dto.ClienteDTO;
import br.edu.unoesc.ads.clientes.entities.Cliente;
import br.edu.unoesc.ads.clientes.repositories.ClienteRepository;
import br.edu.unoesc.ads.clientes.services.ClienteService;

@RestController
@RequestMapping(value="api")
public class ClienteRESTController {
	
	@Autowired
	private ClienteService servico;
	
	@Autowired
	private ClienteRepository repositorio;

	@GetMapping(value = "/clientes")
	public Page<ClienteDTO> findAll(Pageable pageable) {
	return servico.findAll(pageable);
	}

	@GetMapping(value = "/cliente/{id}")
	public ClienteDTO findById(@PathVariable Long id) {
	return servico.findById(id);
	}
	
	//Incluir Cliente
	@PostMapping("/cliente")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
	return repositorio.save(cliente);
	}
	
	//Alterar Cliente
	@PutMapping("/cliente")
	public Cliente atualizarCliente(@RequestBody Cliente cliente) {
	return repositorio.save(cliente);
	}
	
	//Excluir Cliente
	@DeleteMapping("/cliente")
	public void deletarCliente(@RequestBody Cliente cliente) {
	repositorio.delete(cliente);
	}
	
	//Listar por Idade
	@GetMapping(value={"/clienteporidade", "/clienteporidade/{idade}"})
	public List<Cliente> PorIdade(@PathVariable Optional<Long> idade) {
	return repositorio.porIdade(idade.orElse(Long.MIN_VALUE));
	}
}
