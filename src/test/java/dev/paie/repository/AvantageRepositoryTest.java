package dev.paie.repository;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;


//TODO compléter la configuration
@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired private AvantageRepository avantageRepository;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		//TODO sauvegarder un nouvel avantage
		System.out.println("Pierre l'ebrabouilleur de bête");
		Avantage newavantage = new Avantage();
		newavantage.setId((int)(Math.random()*100000));
		newavantage.setCode("code");
		newavantage.setNom("nom");
		newavantage.setMontant(new BigDecimal("15"));
		avantageRepository.save(newavantage);
		
		//TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		boolean bool = false;
		List<Avantage> listavantage = avantageRepository.findAll();
		for (Avantage gr : listavantage ) {
			if(gr.getCode().equals(newavantage.getCode())){
				bool = true;
			}
			
		}
		assertTrue(bool);
		
		//TODO modifier une cotisation
		newavantage.setCode("abdel");
		avantageRepository.save(newavantage);


		//TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
		List<Avantage> listavantageapresmodif = avantageRepository.findAll();
		for (Avantage gr : listavantageapresmodif ) {
			if(gr.getCode().equals(newavantage.getCode())){
				bool = true;
			}
			
		}
		assertTrue(bool);

	}

}