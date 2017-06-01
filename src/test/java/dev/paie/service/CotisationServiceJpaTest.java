package dev.paie.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired private CotisationService cotisationService;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		

		//TODO sauvegarder une nouvelle cotisation
		Cotisation nouveauCotisation = new Cotisation();
		nouveauCotisation.setId((int)(Math.random()*10000)); // Attention c'est très très pas beau !
		nouveauCotisation.setCode("toto");
		nouveauCotisation.setLibelle("totolib");
		nouveauCotisation.setTauxPatronal(new BigDecimal("5"));
		nouveauCotisation.setTauxSalarial(new BigDecimal("10"));
		cotisationService.sauvegarder(nouveauCotisation);

		//TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via laméthode lister
		List<Cotisation> recupCot = cotisationService.lister();
		boolean trouve = false;
		for(Cotisation gr : recupCot){
			//System.out.println(gr.getId() +" == "+ nouveauGrade.getId());
			if(gr.getId().equals(nouveauCotisation.getId()))
				trouve = true;
		}
		assertTrue(trouve);
		

		//TODO modifier une cotisation
		nouveauCotisation.setCode("TOTO");
		cotisationService.mettreAJour(nouveauCotisation);
		
		//TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		recupCot = cotisationService.lister();
		trouve = false;
		for(Cotisation gr : recupCot){
			if(gr.getCode().equals(nouveauCotisation.getCode()))
				trouve = true;
		}
		assertTrue(trouve);
	}

}