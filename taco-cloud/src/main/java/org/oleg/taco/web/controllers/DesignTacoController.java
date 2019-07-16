package org.oleg.taco.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
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

	private boolean ingredientSaved = false;

	@GetMapping
	public String showDesignForm(Model model) {
		if(!ingredientSaved) {
			saveIngredients(ingredientRepository);
		}
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepository.findAll().forEach(i -> ingredients.add(i));
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), IngredientUtil.filterByType(ingredients, type));
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
	public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {

		if (errors.hasErrors()) {
			return "design";
		}
		Taco saved = designRepository.save(design);
		order.addDesign(saved);
		return "redirect:/orders/current";
	}
	private void saveIngredients(IngredientRepository ingredientRepository) {
		ingredientRepository.saveAll(
				Arrays.asList(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
					new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
					new Ingredient("GRBF", "Ground Beef",  Type.PROTEIN),
					new Ingredient("CARN", "Carnitas",  Type.PROTEIN),
					new Ingredient("TMTO", "Diced Tomatoes",  Type.VEGGIES),
					new Ingredient("LETC", "Lettuce",  Type.VEGGIES),
					new Ingredient("CHED", "Cheddar", Type.CHEESE),
					new Ingredient("JACK", "Monterrey Jack",  Type.CHEESE), 
					new Ingredient("SLSA", "Salsa",  Type.SAUCE),
					new Ingredient("SRCR", "Sour Cream",  Type.SAUCE)
				));
		ingredientSaved = true;
	}
}
