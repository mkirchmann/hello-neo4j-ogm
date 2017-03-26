package de.neuenberger.grocerylist.core.intf.db;

import de.neuenberger.grocerylist.model.Shopped;
import de.neuenberger.grocerylist.model.Shopper;
import de.neuenberger.grocerylist.model.ShoppingDay;
import de.neuenberger.grocerylist.model.ShoppingItem;
import de.neuenberger.grocerylist.model.ShoppingItemToShop;

public class NeoRepositories {
	private ApplicationContext context;

	private static final NeoRepositories INSTANCE = new NeoRepositories();
	
	private NeoRepositories() {
		context = new ApplicationContext();
	}
	
	public static NeoRepositories getInstance() {
		return INSTANCE;
	}
	
	public GraphRepositoryForString<Shopped> getShoppedRepository() {
		return context.getGraphRepositoryForString(Shopped.class);
	}

	public GraphRepositoryForString<Shopper> getShopperRepository() {
		return context.getGraphRepositoryForString(Shopper.class);
	}
	
	public GraphRepositoryForString<ShoppingDay> getShoppingDayRepository() {
		return context.getGraphRepositoryForString(ShoppingDay.class);
	}
	
	public GraphRepositoryForString<ShoppingItem> getShoppingItemRepository() {
		return context.getGraphRepositoryForString(ShoppingItem.class);
	}
	
	public GraphRepositoryForString<ShoppingItemToShop> getShoppingItemToShopRepository() {
		return context.getGraphRepositoryForString(ShoppingItemToShop.class);
	}

}
