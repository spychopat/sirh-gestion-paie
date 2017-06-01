package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{


	private PaieUtils paieUtils; 
	private ClassPathXmlApplicationContext context;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		
		context = new ClassPathXmlApplicationContext("app-config.xml");
		paieUtils = context.getBean(PaieUtils.class);
		
		
		// -----------
		res.setSalaireDeBase(paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(
				bulletin.getRemunerationEmploye().getGrade().getTauxBase())));
		// -----------
		res.setSalaireBrut(paieUtils.formaterBigDecimal(
				new BigDecimal(res.getSalaireDeBase()).add(
			    bulletin.getPrimeExceptionnelle())));
		// -----------
		BigDecimal x = new BigDecimal(0);
		for(Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()){
			if(cot.getTauxSalarial() != null)
				x = x.add(cot.getTauxSalarial().multiply(new BigDecimal(res.getSalaireBrut())));
		}
		res.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(x));
		// -----------
		BigDecimal y = new BigDecimal(0);
		for(Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()){
			if(cot.getTauxPatronal() != null)
				y = y.add(cot.getTauxPatronal().multiply(new BigDecimal(res.getSalaireBrut()))); 
		}
		res.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(y));
		// -----------
		res.setNetImposable(paieUtils.formaterBigDecimal(
				new BigDecimal(res.getSalaireBrut()).subtract(
				new BigDecimal(res.getTotalRetenueSalarial()))));
		// -----------
		BigDecimal z = new BigDecimal(0);
		for(Cotisation cot : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()){
			if(cot.getTauxSalarial() != null)
				z = z.add(cot.getTauxSalarial().multiply(new BigDecimal(res.getSalaireBrut()))); 
		}
		res.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(res.getNetImposable()).subtract(z)));
		
		return res;
	}

}
