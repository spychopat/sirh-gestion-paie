package dev.paie.config.aspect;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Configuration
@Aspect
public class ControllerPerformanceAspect {
	

	//@PersistenceContext private EntityManager em;
	@Autowired private PerformanceRepository perfRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);
	@Around("execution(* dev.paie.web.controller.*.*(..))")
	
	
	
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		Performance perf = new Performance();
		perf.setNomService(pjp.getSignature().toString());
		perf.setDateHeure(LocalDateTime.now());
		long avant = System.currentTimeMillis();
		
		LOGGER.debug("Début d'exécution de la méthode " + pjp.getSignature().toString());
		Object resultat = pjp.proceed();
		LOGGER.debug("Fin d'exécution de la méthode");
		
		perf.setTempsExecution(System.currentTimeMillis() - avant);
		
		perfRepo.saveAndFlush(perf);
		//em.persist(perf);
		
		return resultat;
	}
}