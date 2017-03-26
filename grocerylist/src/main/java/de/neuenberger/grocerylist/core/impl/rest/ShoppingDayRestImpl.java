package de.neuenberger.grocerylist.core.impl.rest;

import javax.ws.rs.Path;

import de.neuenberger.grocerylist.core.intf.db.NeoRepositories;
import de.neuenberger.grocerylist.model.ShoppingDay;

@Path("/shoppingday")
public class ShoppingDayRestImpl extends SimpleRestGraphRepositoryImpl<ShoppingDay>{

	public ShoppingDayRestImpl() {
		super(NeoRepositories.getInstance().getShoppingDayRepository());
	}

}
