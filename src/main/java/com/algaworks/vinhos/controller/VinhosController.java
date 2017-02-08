package com.algaworks.vinhos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VinhosController {
	@GetMapping("/vinhos/novo")
	public String novo() {
		return "vinho/cadastro-vinho";
	}
}
