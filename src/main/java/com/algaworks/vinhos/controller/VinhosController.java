package com.algaworks.vinhos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.algaworks.vinhos.model.TipoVinho;
import com.algaworks.vinhos.model.Vinho;
import com.algaworks.vinhos.repository.Vinhos;

@Controller
public class VinhosController {
	
	@Autowired
	private Vinhos vinhos;
	
	@GetMapping("/vinhos/novo")
	public String novo(Model model) {
		//'Anexa' um objeto vinho no POST do html/thymeleaf
		model.addAttribute(new Vinho());
		//
		model.addAttribute("tipos", TipoVinho.values());
		return "vinho/cadastro-vinho";
	}
	//@Valid -> se houver error, atribue o valor ao result e valida depois(se deu erro ou não)
	@PostMapping("/vinhos/novo")
	public String salvar(@Valid Vinho vinho, BindingResult result) {
		if(result.hasErrors()) {
			
		}
		vinhos.save(vinho);
		return "redirect:/vinhos/novo";
	}
}
