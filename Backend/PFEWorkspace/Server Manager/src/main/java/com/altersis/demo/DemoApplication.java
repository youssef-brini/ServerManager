package com.altersis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.altersis.demo.entity.Serveur;
import com.altersis.demo.entity.Status;
import com.altersis.demo.repository.ServeurRepository;
import com.altersis.demo.service.IServeurService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	ServeurRepository serveurService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		Serveur s1 = new Serveur("Apache","147.123.0.1","64GB","Web servers","",Status.Server_UP);
		Serveur s2 = new Serveur("WinSCP","148.123.0.1","64GB","FTP servers","",Status.Server_UP);
		Serveur s3 = new Serveur("local","127.0.0.1","2To","local servers","",Status.Server_Down);
		serveurService.save(s2);
		serveurService.save(s1);
		serveurService.save(s3);
		
	}

}
