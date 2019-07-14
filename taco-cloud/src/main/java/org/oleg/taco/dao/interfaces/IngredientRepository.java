package org.oleg.taco.dao.interfaces;

import org.oleg.taco.entity.Ingredient;

import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository 
		extends CrudRepository<Ingredient, String>{

}
