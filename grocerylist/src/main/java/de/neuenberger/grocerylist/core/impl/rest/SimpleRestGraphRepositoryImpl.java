package de.neuenberger.grocerylist.core.impl.rest;

import javax.enterprise.context.RequestScoped;

import de.neuenberger.grocerylist.core.intf.db.GraphRepository;
import de.neuenberger.grocerylist.core.intf.rest.ISimpleRestGraphRepository;

@RequestScoped
public class SimpleRestGraphRepositoryImpl<T> implements ISimpleRestGraphRepository<T> {

	private final GraphRepository<T> repository;
	
	public SimpleRestGraphRepositoryImpl(GraphRepository<T> repository) {
		this.repository = repository;
	}
	
	@Override
	public void delete(T arg0) {
		repository.delete(arg0);
	}

	@Override
	public T save(T arg0) {
		return repository.save(arg0);
	}

	@Override
	public Iterable<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<Long> arg0) {
		return repository.findAll(arg0);
	}
	

}
