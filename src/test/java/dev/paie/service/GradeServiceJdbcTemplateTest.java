package dev.paie.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.BooleanLiteral;
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
		
		
		
		System.out.println("abdel le bg");
		//TODO sauvegarder un nouveau grade
		Grade newgrade = new Grade();
		newgrade.setId((int)(Math.random()*100000));
		newgrade.setCode("code");
		newgrade.setNbHeuresBase(new BigDecimal("35"));
		newgrade.setTauxBase(new BigDecimal("15"));
		System.out.println(newgrade);
		gradeService.sauvegarder(newgrade);
		System.out.println(gradeService);
		boolean bool = false;
		//TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> listgrade = gradeService.lister();
		for (Grade gr : listgrade ) {
			if(gr.getCode().equals(newgrade.getCode())){
				bool = true;
			}
			
		}
		assertTrue(bool);
		//TODO modifier un grade
		newgrade.setCode("abdel");
		gradeService.mettreAJour(newgrade);
		
		//TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		List<Grade> listgradeapresmodif = gradeService.lister();
		bool = false;
		for (Grade gr : listgradeapresmodif ) {
			if(gr.getCode().equals(newgrade.getCode())){
				bool = true;
			}
			
		}
		assertTrue(bool);
		
		
		

	}

}