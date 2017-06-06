package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.util.GradeMapper;

@Service
public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);
	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		em.merge(cotisation);

	}
	@Override
	public List<Cotisation> lister() {
		TypedQuery<Cotisation> query = em.createQuery("SELECT c FROM Cotisation c", Cotisation.class);
		return query.getResultList();
		
	}


}