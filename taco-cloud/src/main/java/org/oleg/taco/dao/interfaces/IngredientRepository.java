package org.oleg.taco.dao.interfaces;

import org.oleg.taco.entity.Ingredient;

public interface IngredientRepository {

	Iterable<Ingredient> findAll();

	Ingredient findOne(String id);

	Ingredient save(Ingredient ingredient);
}
