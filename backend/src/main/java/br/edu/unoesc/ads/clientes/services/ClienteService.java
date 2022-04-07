package br.edu.unoesc.ads.clientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.unoesc.ads.clientes.dto.ClienteDTO;
import br.edu.unoesc.ads.clientes.entities.Cliente;
import br.edu.unoesc.ads.clientes.repositories.ClienteRepository;

@Service
public class ClienteService {
	
@Autowired
private ClienteRepository repositorio;

@Transactional(readOnly = true)
public Page<ClienteDTO> findAll(Pageable pageable) {
Page<Cliente> resultado = repositorio.findAll(pageable);
Page<ClienteDTO> pagina = resultado.map(x -> new ClienteDTO(x));
return pagina;
}

@Transactional(readOnly = true)
public ClienteDTO findById(Long id) {
Cliente resultado = repositorio.findById(id).get();
ClienteDTO dto = new ClienteDTO(resultado);
return dto;
}
}