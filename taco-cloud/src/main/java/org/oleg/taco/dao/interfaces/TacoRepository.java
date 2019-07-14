package org.oleg.taco.dao.interfaces;

import org.oleg.taco.entity.Taco;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository 
		extends CrudRepository<Taco, Long> {

}
