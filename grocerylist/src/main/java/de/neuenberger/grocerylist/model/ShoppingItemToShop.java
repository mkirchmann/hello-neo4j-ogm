package de.neuenberger.grocerylist.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import de.neuenberger.grocerylist.model.units.Unit;

@RelationshipEntity(type = "toshop")
public class ShoppingItemToShop {
	@GraphId
	private Long id;

	@StartNode
	private ShoppingDay shoppingDay;
	@EndNode
	private ShoppingItem shoppingItem;

	private long amount;
	private Unit unit;

	public ShoppingItemToShop() {

	}

	public ShoppingItemToShop(final ShoppingDay shoppingDay, final ShoppingItem item, final int amount, final Unit unit) {
		this.shoppingDay = shoppingDay;
		shoppingItem = item;
		this.amount = amount;
		this.unit = unit;
	}

	/**
	 * @return the shoppingDay
	 */
	public ShoppingDay getShoppingDay() {
		return shoppingDay;
	}

	/**
	 * @param shoppingDay
	 *            the shoppingDay to set
	 */
	public void setShoppingDay(final ShoppingDay shoppingDay) {
		this.shoppingDay = shoppingDay;
	}

	/**
	 * @return the shoppingItem
	 */
	public ShoppingItem getShoppingItem() {
		return shoppingItem;
	}

	/**
	 * @param shoppingItem
	 *            the shoppingItem to set
	 */
	public void setShoppingItem(final ShoppingItem shoppingItem) {
		this.shoppingItem = shoppingItem;
	}

	/**
	 * @return the amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(final long amount) {
		this.amount = amount;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(final Unit unit) {
		this.unit = unit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShoppingItemToShop [id=" + id + ", shoppingDay=" + shoppingDay + ", shoppingItem=" + shoppingItem
				+ ", amount=" + amount + ", unit=" + unit + "]";
	}

}
