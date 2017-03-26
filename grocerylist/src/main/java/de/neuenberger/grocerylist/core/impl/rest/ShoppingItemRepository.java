package de.neuenberger.grocerylist.core.impl.rest;

import de.neuenberger.grocerylist.core.intf.db.NeoRepositories;
import de.neuenberger.grocerylist.model.ShoppingItem;

public class ShoppingItemRepository extends SimpleRestGraphRepositoryImpl<ShoppingItem>{

	public ShoppingItemRepository() {
		super(NeoRepositories.getInstance().getShoppingItemRepository());
	}

}
