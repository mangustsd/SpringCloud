package org.oleg.taco.utils;

import java.util.ArrayList;
import java.util.List;

import org.oleg.taco.entity.Ingredient;
import org.oleg.taco.entity.Ingredient.Type;

public final class IngredientUtil {
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
