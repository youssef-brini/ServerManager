package com.altersis.demo.service;

import java.io.IOException;
import java.util.Collection;

import com.altersis.demo.entity.Serveur;

public interface IServeurService {
	public Serveur addServeur(Serveur serveur);
	public Serveur findServeur(Long id);
	public Serveur updateServeur(Serveur serveur);
	public boolean deleteServeur(Long id);
	public Collection<Serveur> findAll(); 
	public Serveur pingServeur(String ipAddress) throws IOException;
}
