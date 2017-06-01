package dev.paie.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

// compléter la configuration
@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired private AvantageRepository avantageRepository;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder un nouvel avantage
		Avantage nouveauAvantage = new Avantage();
		nouveauAvantage.setId((int)(Math.random()*10000)); // Attention c'est très très pas beau !
		nouveauAvantage.setCode("toto");
		nouveauAvantage.setMontant(new BigDecimal("5"));
		nouveauAvantage.setNom("tata");
		avantageRepository.save(nouveauAvantage);
		
		// vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		List<Avantage> recupAvanttage = avantageRepository.findAll();
		boolean trouve = false;
		for(Avantage av : recupAvanttage){
			if(av.getId().equals(nouveauAvantage.getId()))
				trouve = true;
		}
		assertTrue(trouve);
		
		// modifier un avantage
		nouveauAvantage.setCode("TOTO");
		avantageRepository.save(nouveauAvantage);
		
		// vérifier que les modifications sont bien prises en compte via la méthode findOne
		recupAvanttage = avantageRepository.findAll();
		trouve = false;
		for(Avantage av : recupAvanttage){
			if(av.getCode().equals(nouveauAvantage.getCode()))
				trouve = true;
		}
		assertTrue(trouve);
	}
}