package com.cosmetique.auth.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cosmetique.auth.model.Ingredient;
import com.cosmetique.auth.model.ProduitCosmetique;
import com.cosmetique.auth.model.Role;
import com.cosmetique.auth.model.User;
import com.cosmetique.auth.repository.RoleRepository;
import com.cosmetique.auth.service.SecurityService;
import com.cosmetique.auth.service.UserService;
import com.cosmetique.auth.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {

		model.addAttribute("userForm", new User());
		// model.addAttribute("produitForm",new ProduitCosmetique());
		// model.addAttribute("ingredientForm",new Ingredient());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<Role> initializeProfiles() {
		return roleRepository.findAll();
	}
}
