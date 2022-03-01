package com.altersis.demo.service;

import java.io.IOException;
import java.util.List;

import com.altersis.demo.entity.Serveur;

public interface IServeurService {
	public Serveur addServeur(Serveur serveur);
	public Serveur findServeur(Long id);
	public Serveur updateServeur(Serveur serveur);
	public boolean deleteServeur(Long id);
	public List<Serveur> findAll(); 
	public Serveur pingServeur(String ipAddress) throws IOException;
}
