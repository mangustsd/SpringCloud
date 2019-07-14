package org.oleg.taco.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.oleg.taco.dao.interfaces.IngredientRepository;
import org.oleg.taco.dao.interfaces.TacoRepository;
import org.oleg.taco.entity.Ingredient;
import org.oleg.taco.entity.Ingredient.Type;
import org.oleg.taco.entity.Order;
import org.oleg.taco.entity.Taco;
import org.oleg.taco.utils.IngredientUtil;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private TacoRepository designRepository;
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepository.findAll().forEach(i ->ingredients.add(i));
		Type[] types = Ingredient.Type.values();
		for(Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
							   IngredientUtil.filterByType(ingredients,type));
		}
		model.addAttribute("design", new Taco());
		return "design";
	}

	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}
	
	@PostMapping
	public String processDesign(
			@Valid Taco design, Errors errors,
			@ModelAttribute Order order) {
		
		if (errors.hasErrors()) {
			return "design";
		}
		Taco saved = designRepository.save(design);
		order.addDesign(saved);
		return "redirect:/orders/current";
	}

}
