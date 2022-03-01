package com.altersis.demo.service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.altersis.demo.entity.Serveur;
import com.altersis.demo.entity.Status;
import com.altersis.demo.repository.ServeurRepository;
@Service
public class ServeurImpl implements IServeurService{

	@Autowired
	ServeurRepository serveurRepository;
	@Override
	public Serveur addServeur(Serveur serveur) {
		serveur.setImgURL(setServeurImgURL());
		return serveurRepository.save(serveur);
	}

	private String setServeurImgURL() {
		String[] images = {"serveur1.png","serveur2.png","serveur3.png"};
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/serveur/image/"+images[new Random().nextInt(4)]).toUriString();
	}

	@Override
	public Serveur findServeur(Long id) {
		
		Serveur s = serveurRepository.findById(id).get();
		return s;
	}

	@Override
	public Serveur updateServeur(Serveur serveur) {
		
		return serveurRepository.save(serveur);
	}

	@Override
	public boolean deleteServeur(Long id) {
		serveurRepository.deleteById(id);
		return true;
	}

	@Override
	public Collection<Serveur> findAll() {
		
		return serveurRepository.findAll();
	}

	@Override
	public Serveur pingServeur(String ipAddress) throws IOException {
		Serveur serveur = serveurRepository.findByIpAddress(ipAddress);
		InetAddress address = InetAddress.getByName(ipAddress);
		serveur.setStatus(address.isReachable(10000)? Status.Server_UP : Status.Server_Down);
		serveurRepository.save(serveur);
		return serveur;
	}

}
