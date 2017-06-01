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
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired private GradeService gradeService;
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {

		// sauvegarder un nouveau grade
		Grade nouveauGrade = new Grade();
		nouveauGrade.setId((int)(Math.random()*10000)); // Attention c'est très très pas beau !
		nouveauGrade.setCode("PDG");
		nouveauGrade.setNbHeuresBase(new BigDecimal("6548"));
		nouveauGrade.setTauxBase(new BigDecimal("11"));
		gradeService.sauvegarder(nouveauGrade);
		
		// vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> recupGrade = gradeService.lister();
		boolean trouve = false;
		for(Grade gr : recupGrade){
			//System.out.println(gr.getId() +" == "+ nouveauGrade.getId());
			if(gr.getId().equals(nouveauGrade.getId()))
				trouve = true;
		}
		assertTrue(trouve);
		
		
		// modifier un grade
		nouveauGrade.setCode("TOTO");
		gradeService.mettreAJour(nouveauGrade);
		// vérifier que les modifications sont bien prises en compte via la méthode lister
		recupGrade = gradeService.lister();
		trouve = false;
		for(Grade gr : recupGrade){
			if(gr.getCode().equals(nouveauGrade.getCode()))
				trouve = true;
		}
		assertTrue(trouve);
	}
}