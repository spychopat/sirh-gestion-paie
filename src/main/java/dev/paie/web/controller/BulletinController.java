package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired private PeriodeRepository periode;
	@Autowired private RemunerationEmployeRepository remuEmploye;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		//mv.addObject("prefixMatricule","M00");
		mv.addObject("periode",periode.findAll());
		mv.addObject("employe",remuEmploye.findAll());
		
		
		return mv;
	}
	
	
	// TODO Post
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView ListeBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletin");
		
		// TODO
		
		
		return mv;
	}


}