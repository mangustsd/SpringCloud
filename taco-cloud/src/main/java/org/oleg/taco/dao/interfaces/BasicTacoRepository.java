package org.oleg.taco.dao.interfaces;

import org.oleg.taco.entity.Taco;
import org.springframework.data.repository.NoRepositoryBean;
@Deprecated
public interface BasicTacoRepository {
	public Taco save(Taco taco);
}
