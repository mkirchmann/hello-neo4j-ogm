package de.neuenberger.grocerylist.core.intf.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface ISimpleRestGraphRepository<T> {
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(T arg0);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public T save(T arg0);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<T> findAll();
	
	@POST
	@Path("/byids")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<T> findAll(Iterable<Long> arg0);
}
