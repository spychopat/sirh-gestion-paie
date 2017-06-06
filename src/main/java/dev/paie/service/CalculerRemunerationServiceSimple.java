package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	
	private PaieUtils paieUtils;
	private ClassPathXmlApplicationContext context;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		context = new ClassPathXmlApplicationContext("app-config.xml");
		paieUtils = context.getBean(PaieUtils.class);
		
		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		res.setSalaireDeBase(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye()
				.getGrade()
				.getNbHeuresBase()
				.multiply(bulletin
			    .getRemunerationEmploye()
			    .getGrade().getTauxBase())));
		
		res.setSalaireBrut(paieUtils.formaterBigDecimal(bulletin.getRemunerationEmploye()
				.getGrade()
				.getNbHeuresBase()
				.multiply(bulletin
			    .getRemunerationEmploye()
			    .getGrade().getTauxBase()).add(bulletin.getPrimeExceptionnelle())));
		
		BigDecimal s = new BigDecimal(0);
		for(Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()) {
			if(cot.getTauxSalarial() != null)
			s = s.add(cot.getTauxSalarial().multiply(new BigDecimal(res.getSalaireBrut())));
		}
		
		res.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(s));
		
		BigDecimal t = new BigDecimal(0);
		for(Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()) {
			if(cot.getTauxPatronal() != null)
			t = t.add(cot.getTauxPatronal().multiply(new BigDecimal(res.getSalaireBrut())));
		}
		
		res.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(t));
		
		res.setNetImposable(paieUtils.formaterBigDecimal(new BigDecimal(res.getSalaireBrut()).subtract(new BigDecimal(res.getTotalRetenueSalarial()))));
		
		
		BigDecimal u = new BigDecimal(0);
		for(Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()) {
			if(cot.getTauxSalarial() != null)
			u = u.add(cot.getTauxSalarial().multiply(new BigDecimal(res.getSalaireBrut())));
		}
		res.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(res.getNetImposable()).subtract(u)));
		
		return res;
	}

}