package com.altersis.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.altersis.demo.entity.Serveur;
import com.altersis.demo.entity.Status;
import com.altersis.demo.service.IServeurService;
@RestController
@CrossOrigin
public class ServeurController {
	@Autowired
	IServeurService serveurService;
	
	@GetMapping(value="/serveur/{id}")
	public Serveur findOneServeurById(@PathVariable Long id){

		return serveurService.findServeur(id);
	}
	
	@GetMapping(value="/serveur/ping/{idAddress}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public String pingServeur(@PathVariable String idAddress) throws IOException{
		Serveur serveur = serveurService.pingServeur(idAddress);
		if(serveur!= null ) {
			Status state = serveur.getStatus();	
			return state == Status.Server_UP ? "{  \"response\" : \"Ping Success\" }": "{  \"response\" : \"Ping failed\" }" ;
		}
		else
			return null;
		
		
		
	}
	
	@PostMapping(value="/serveur")
	public Serveur addServeur(@RequestBody Serveur s){
		return serveurService.addServeur(s);
		}
	
	@RequestMapping(value="/serveur", method=RequestMethod.GET)
	public List<Serveur> findServeurs ()
	{
	return serveurService.findAll();
	}
	
	@PutMapping(value="/serveur")
	public Serveur updateServeur(@RequestBody Serveur s){
		return serveurService.updateServeur(s);
		}
	@DeleteMapping(value="/serveur/{id}")
	public void DeleteServeur(@PathVariable Long id){
		serveurService.deleteServeur(id);
		
		}
	
	@GetMapping(value="/serveur/image/{fileName}")
	public byte[] getServeurImg(@PathVariable String fileName) throws IOException{
		return Files.readAllBytes(Paths.get("D:/AltersisApplication/Backend/PFEWorkspace/images/"+fileName)) ;
	}
	
	
}
