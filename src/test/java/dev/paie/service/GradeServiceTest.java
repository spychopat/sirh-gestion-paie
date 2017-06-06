package dev.paie.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.JpaConfig;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
//@Transactional
public class GradeServiceTest {
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder une nouvelle cotisation
		Grade grade = new Grade();
		grade.setCode("toto");
		gradeService.sauvegarder(grade);
		
		
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}