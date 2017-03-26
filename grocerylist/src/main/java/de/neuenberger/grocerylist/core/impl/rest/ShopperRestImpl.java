package de.neuenberger.grocerylist.core.impl.rest;

import javax.ws.rs.Path;

import de.neuenberger.grocerylist.core.intf.db.NeoRepositories;
import de.neuenberger.grocerylist.model.Shopper;

@Path("/shopper")
public class ShopperRestImpl extends SimpleRestGraphRepositoryImpl<Shopper>{

	public ShopperRestImpl() {
		super(NeoRepositories.getInstance().getShopperRepository());
	}

}
