package com.altersis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altersis.demo.entity.Serveur;
@Repository
public interface ServeurRepository extends JpaRepository<Serveur, Long>{
	Serveur findByIpAddress(String ipAddress);

}
