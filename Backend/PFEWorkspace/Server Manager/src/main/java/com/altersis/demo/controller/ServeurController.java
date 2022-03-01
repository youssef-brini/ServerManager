package com.altersis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altersis.demo.entity.Serveur;
import com.altersis.demo.service.IServeurService;
@RestController
public class ServeurController {
	@Autowired
	IServeurService serveurService;
	@GetMapping(value="/serveur/{id}")
	public Serveur findOneServeurById(@PathVariable Long id){

		return serveurService.findServeur(id);
	}
}
