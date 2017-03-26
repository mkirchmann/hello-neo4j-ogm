package de.neuenberger.grocerylist.core.impl.rest;

import javax.ws.rs.Path;

import de.neuenberger.grocerylist.core.intf.db.NeoRepositories;
import de.neuenberger.grocerylist.model.Shopped;

@Path("shopped")
public class ShoppedRestImpl extends SimpleRestGraphRepositoryImpl<Shopped>{

	public ShoppedRestImpl() {
		super(NeoRepositories.getInstance().getShoppedRepository());
	}

}
