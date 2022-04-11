package br.edu.unoesc.ads.clientes.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.ads.clientes.entities.Cliente;
import br.edu.unoesc.ads.clientes.repositories.ClienteRepository;

	@Controller
	@CrossOrigin(origins = "*")
	public class ClienteController {
		@Autowired
		ClienteRepository clienteRepository;
		
		@GetMapping("/clientes")
			public String listarClientes(Model model) {
			SimpleDateFormat dateFormat = new SimpleDateFormat();
			Calendar cal = Calendar.getInstance();
			String sDataAux;
			dateFormat.applyPattern("dd 'de' MMMM 'de' yyyy");
			sDataAux = dateFormat.format(cal.getTime());
			model.addAttribute("data", LocalDateTime.now());
			model.addAttribute("dataExtenso", "<b>" + sDataAux + "</b>");
			model.addAttribute("clientes", clienteRepository.findAll());
			return "lista_clientes";
		}
		@GetMapping("/incluir_cliente")
			public String formCliente(Model model) {
			model.addAttribute("cliente", new Cliente());
			model.addAttribute("adicionar", true);
			return "form_cliente";
		}
		@PostMapping("/processa_incluir_cliente")
			public String processaFormIncluirCliente(@Valid Cliente cliente, BindingResult resultado) {
			if (resultado.hasErrors()) {
			return "form_cliente";
		}
		clienteRepository.save(cliente);
		return "redirect:/clientes";
		}
		@GetMapping("/alterar_cliente/{id}")
		public String alterar(@PathVariable("id") long id, Model model) {
			Cliente cliente = clienteRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Cliente inválido Id:" + id));
			model.addAttribute("cliente", cliente);
			model.addAttribute("adicionar", false);
		return "form_cliente";
		}
		@PostMapping("/processa_alterar_cliente/{id}")
			public String processaFormAlterarProduto(@PathVariable("id") long id, @Valid Cliente cliente, BindingResult 
			resultado, Model model) {
			if (resultado.hasErrors()) {
			cliente.setId(id);
			return "form_cliente";
		}
		clienteRepository.save(cliente);
			return "redirect:/clientes";
		}
		@GetMapping("/excluir_cliente/{id}")
			public String remover(@PathVariable("id") long id, Model model) {
			Cliente cliente = clienteRepository.findById(id).get();
			clienteRepository.delete(cliente);
			return "redirect:/clientes";
	}
	}