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
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired private EntrepriseRepository entreprise;
	@Autowired private ProfilRepository profil;
	@Autowired private GradeRepository grade;
	@Autowired private PeriodeRepository periode;
	@Autowired private RemunerationEmployeRepository remuEmploye;
	
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		//mv.addObject("prefixMatricule","M00");
		mv.addObject("employes",remuEmploye.findAll());
		mv.addObject("entreprise",entreprise.findAll());
		mv.addObject("profil",profil.findAll());
		mv.addObject("grade",grade.findAll());
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		//mv.addObject("prefixMatricule","M00");
		mv.addObject("entreprise",entreprise.findAll());
		mv.addObject("profil",profil.findAll());
		mv.addObject("grade",grade.findAll());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployePost(
			@RequestParam("matricule") String matricule,
			@RequestParam("entreprise") Integer entreprise_id,
			@RequestParam("profil") Integer profil_id,
			@RequestParam("grade") Integer grade_id,
			Model model) {
		
		System.out.println("matricule : "+matricule+"\nentreprise : "+entreprise_id+"\nprofil : "+profil_id+"\ngrade : "+grade_id);
		
		RemunerationEmploye newEmploye = new RemunerationEmploye(matricule,entreprise.findOne(entreprise_id),profil.findOne(profil_id),grade.findOne(grade_id));
		remuEmploye.saveAndFlush(newEmploye);
		
		return new ModelAndView("redirect:./lister");
		
	}
	
	
	
	



}