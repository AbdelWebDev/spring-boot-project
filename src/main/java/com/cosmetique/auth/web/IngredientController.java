package com.cosmetique.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cosmetique.auth.model.Ingredient;
import com.cosmetique.auth.repository.IngredientRepository;

@Controller
public class IngredientController {
	@Autowired
	private IngredientRepository ingredients;
	
//	@RequestMapping(name="/addIngredient",method=RequestMethod.GET)
//	public String ajouterIngredient(Model model){
//		
//		model.addAttribute("ingredientForm", new Ingredient());
//		return "ingredient";
//		
//	}
	@RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
    public String ajouterIngredient(@ModelAttribute("ingredientForm") Ingredient ingredientForm, Model model) {

		ingredients.save(ingredientForm);

        return "redirect:/listIngredient";
    }
	
	@RequestMapping(value = "/listIngredient", method = RequestMethod.GET)
    public String gteListIngredient(Model model) {

        return "listIngredient";
    }
}