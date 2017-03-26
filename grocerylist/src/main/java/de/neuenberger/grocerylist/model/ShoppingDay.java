package de.neuenberger.grocerylist.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class ShoppingDay {
	@GraphId
	private Long id;

	private Date date;

	private Shopper shopper;

	public ShoppingDay() {

	}

	/**
	 * @param date
	 */
	public ShoppingDay(final Shopper shopper, final Date date) {
		super();
		setShopper(shopper);
		setDate(date);
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * @return the shopper
	 */
	public Shopper getShopper() {
		return shopper;
	}

	/**
	 * @param shopper
	 *            the shopper to set
	 */
	public void setShopper(final Shopper shopper) {
		this.shopper = shopper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShoppingDay [id=" + id + ", date=" + date + ", shopper=" + shopper + "]";
	}

}
