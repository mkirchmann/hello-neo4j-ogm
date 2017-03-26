package de.neuenberger.grocerylist.core.impl.rest;

import javax.ws.rs.Path;

import de.neuenberger.grocerylist.core.intf.db.NeoRepositories;
import de.neuenberger.grocerylist.model.ShoppingItemToShop;

@Path("shoppingitemtoshop")
public class ShoppingItemToShopRestImpl extends SimpleRestGraphRepositoryImpl<ShoppingItemToShop>{

	public ShoppingItemToShopRestImpl() {
		super(NeoRepositories.getInstance().getShoppingItemToShopRepository());
	}

}
