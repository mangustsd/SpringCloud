package org.oleg.taco.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
/**
 * 
 * @author Unit
 * Ingredient entity 
 * constructor, setters and getters are auto genereted by lombok library
 */
public class Ingredient {

	private final String id;
	private final String name;
	private final Type type;
	
	public static enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
