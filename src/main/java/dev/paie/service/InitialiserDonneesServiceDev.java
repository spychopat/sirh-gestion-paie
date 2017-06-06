package dev.paie.service;

import javax.persistence.EntityManager;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	//@Autowired private CotisationService cotisationService;
	@Autowired private ApplicationContext context;
	@Autowired private EntityManager em;
	
	
	//private ClassPathXmlApplicationContext context;
	
	@Override
	public void initialiser() {
		
		//context = new ClassPathXmlApplicationContext("cotisations-imposables.xml");
		
		//cotisationService.sauvegarder(context.getBean("sp01", Cotisation.class));
		
		
		//context.getBeansOfType(Avantage.class).forEach((nomBean, bean) -> em.persist(bean));
        //context.getBeansOfType(Grade.class).forEach((nomBean, bean) -> em.persist(bean));
        //context.getBeansOfType(Entreprise.class).forEach((nomBean, bean) -> em.persist(bean));
        context.getBeansOfType(Cotisation.class).forEach((nomBean, bean) -> em.persist(bean));
        //context.getBeansOfType(Periode.class).forEach((nomBean, bean) -> em.persist(bean));
        //context.getBeansOfType(BulletinSalaire.class).forEach((nomBean, bean) -> em.persist(bean));
        //context.getBeansOfType(RemunerationEmploye.class).forEach((nomBean, bean) -> em.persist(bean));
        //context.getBeansOfType(ProfilRemuneration.class).forEach((nomBean, bean) -> em.persist(bean));

	}

}
