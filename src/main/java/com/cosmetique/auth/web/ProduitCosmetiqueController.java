package com.cosmetique.auth.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cosmetique.auth.model.ProduitCosmetique;
import com.cosmetique.auth.repository.ProduitCosmetiqueRepository;

@Controller
public class ProduitCosmetiqueController {
	
	@Autowired
	private ProduitCosmetiqueRepository produitCosmetique;
	
	@RequestMapping(name="/addProduct",method=RequestMethod.GET)
	public String ajouterProduit(Model model){
		
		model.addAttribute("produitForm",new ProduitCosmetique());
		
		return "produit";
		
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String ajouterProduit(@ModelAttribute("produitForm") ProduitCosmetique produitForm, Model model) {

		produitCosmetique.save(produitForm);

        return "redirect:/listProduit";
    }
	
	@RequestMapping(value = "/listProduit", method = RequestMethod.GET)
    public String gteListProduct(Model model) {

        return "listProduit";
    }
	
	

}
