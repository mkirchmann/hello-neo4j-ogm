package de.neuenberger.grocerylist.core.intf.db;

import java.util.List;

/**
 * 
 * @author Michael
 *
 * @param <S> The type.
 */
public interface GraphRepository<S> {
	Iterable<S> findAll(Iterable<Long> nodeIds);

	S byGraphId(long id);

	S byGraphId(Long id, int depth);

	Iterable<S> findAll();

	Iterable<S> findAll(int depth);

	void delete(S arg0);

	S save(S arg0);

	List<S> saveAll(List<S> contacts);
}
