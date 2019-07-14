package org.oleg.taco.dao.interfaces;

import org.oleg.taco.entity.Ingredient;

public interface BasicIngredientRepository {
	
	public Iterable<Ingredient> findAll();
	
	public Ingredient findOne(String id) ;
	
	public Ingredient save(Ingredient ingredient);

}
