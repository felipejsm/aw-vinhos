package com.algaworks.vinhos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.vinhos.model.TipoVinho;
import com.algaworks.vinhos.model.Vinho;
import com.algaworks.vinhos.repository.Vinhos;

@Controller
public class VinhosController {
	
	@Autowired
	private Vinhos vinhos;
	
	@GetMapping("/vinhos/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("vinho/cadastro-vinho");
		mv.addObject("tipos", TipoVinho.values());
		return mv;
	}
	//@Valid -> se houver error, atribue o valor ao result e valida depois(se deu erro ou não)
	@PostMapping("/vinhos/novo")
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result) {
		if(result.hasErrors()) {
			return novo(vinho);//os valores do form persistem
		}
		vinhos.save(vinho);
		return new ModelAndView("redirect:/vinhos/novo");
	}
}
