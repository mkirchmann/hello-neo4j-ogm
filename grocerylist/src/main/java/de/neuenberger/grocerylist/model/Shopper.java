package de.neuenberger.grocerylist.model;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Shopper {
	@GraphId
	private Long id;

	private String name;

	private Set<ShoppingDay> shoppingDays;

	public Shopper(final String name) {
		setName(name);
	}

	public Shopper() {

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return the shoppingDay
	 */
	public Set<ShoppingDay> getShoppingDays() {
		return shoppingDays;
	}

	/**
	 * @param shoppingDays
	 *            the shoppingDay to set
	 */
	public void setShoppingDays(final Set<ShoppingDay> shoppingDays) {
		this.shoppingDays = shoppingDays;
	}

	public void addShoppingDay(final ShoppingDay shoppingDay) {
		if (shoppingDays == null) {
			shoppingDays = new HashSet<ShoppingDay>();
		}
		shoppingDays.add(shoppingDay);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shopper [id=" + id + ", name=" + name + ", shoppingDays=" + shoppingDays + "]";
	}
}
