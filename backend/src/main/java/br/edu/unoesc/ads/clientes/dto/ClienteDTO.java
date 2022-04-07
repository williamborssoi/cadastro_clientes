package br.edu.unoesc.ads.clientes.dto;

import br.edu.unoesc.ads.clientes.entities.Cliente;

public class ClienteDTO {
private Long id;
private String nome;
private Long idade;
private String endereco;
private Long cpf;
public ClienteDTO() { }
public ClienteDTO(Long id, String nome, Long idade, String endereco, Long cpf) {
this.id = id;
this.nome = nome;
this.idade = idade;
this.endereco = endereco;
this.cpf = cpf;
}

public ClienteDTO(Cliente cliente) {
this.id = cliente.getId();
this.nome = cliente.getNome();
this.idade = cliente.getIdade();
this.endereco = cliente.getEndereco();
this.cpf = cliente.getCpf();
}
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }

public Long getIdade() { return idade; }
public void setIdade(Long idade) { this.idade = idade; }

public String getEndereco() { return endereco; }
public void setEndereco(String endereco) { this.endereco = endereco; }

public Long getCpf() { return cpf; }
public void setCpf(Long cpf) { this.cpf = cpf; }

}