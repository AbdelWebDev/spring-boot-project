package com.cosmetique.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cosmetique.auth.model.Effet;
import com.cosmetique.auth.repository.EffetRepository;

@Controller
public class EffetController {

	@Autowired
	private EffetRepository effets;
	
//	@RequestMapping(name="/addEffet",method=RequestMethod.GET)
//	public String ajouterEffet(Model model){
//		
//		model.addAttribute("effetForm",new Effet());
//		return "effet";
//		
//	}
	
	@RequestMapping(value = "/addEffet", method = RequestMethod.POST)
    public String registration(@ModelAttribute("effetForm") Effet effetForm, Model model) {

		effets.save(effetForm);

        return "redirect:/listEffet";
    }
	
	@RequestMapping(value = "/listEffet", method = RequestMethod.GET)
    public String gteListIngredient(Model model) {

        return "listEffet";
    }
}