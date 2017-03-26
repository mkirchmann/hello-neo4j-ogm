package de.neuenberger.grocerylist.core.impl.rest;

import javax.ws.rs.Path;

import de.neuenberger.grocerylist.core.intf.db.NeoRepositories;
import de.neuenberger.grocerylist.model.ShoppingItem;

@Path("shoppingitem")
public class ShoppingItemRepository extends SimpleRestGraphRepositoryImpl<ShoppingItem>{

	public ShoppingItemRepository() {
		super(NeoRepositories.getInstance().getShoppingItemRepository());
	}

}
