package com.algaworks.vinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.algaworks.vinhos.model.Vinho;

@Controller
public class VinhosController {
	@GetMapping("/vinhos/novo")
	public String novo() {
		return "vinho/cadastro-vinho";
	}
	@PostMapping("/vinhos/novo")
	public String salvar(Vinho vinho) {
		return "";
	}
}
