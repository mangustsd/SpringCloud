package org.oleg.taco.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Unit
 * Ingredient entity 
 * constructor, setters and getters are auto genereted by lombok library
 */
@Data
@RequiredArgsConstructor
public class Ingredient {

	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
	public static List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		List<Ingredient> selectedIngredients = new ArrayList<Ingredient>();
		for(Ingredient ingredient : ingredients) {
			if(ingredient.getType().equals(type)) {
				selectedIngredients.add(ingredient);
			}
		}
		return selectedIngredients;
	}
}
