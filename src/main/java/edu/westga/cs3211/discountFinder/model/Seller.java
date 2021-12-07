/**
 * 
 */
package edu.westga.cs3211.discountFinder.model;

/**
 * @author Brianna Irie
 * @version Fall 2021
 *
 */
public class Seller {
	private String name;
	private double closetStoreDistance;
	
	/**
	 * Instantiates new Seller object.
	 *
	 * preconditions: none
	 * postconditions: none
	 */
	public Seller(String name, double closetStoreDistance) {
		this.name = name;
		this.closetStoreDistance = closetStoreDistance;
	}

	/**
	 * Gets the name 
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the closetStoreDistance 
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @return the closetStoreDistance
	 */
	public double getClosetStoreDistance() {
		return closetStoreDistance;
	}
}
