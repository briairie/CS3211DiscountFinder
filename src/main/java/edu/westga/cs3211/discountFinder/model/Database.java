package edu.westga.cs3211.discountFinder.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The Database
 * @author Brianna Irie
 * @version Fall 2021
 */
public class Database {
	private Collection<Item> data;
	
	/**
	 * Instantiates new Database object.
	 *
	 * preconditions:  none
	 * postconditions: none
	 */
	public Database() {
		this.data = new ArrayList<Item>();
		this.data.add(new Item("Flower Pot Small", 3.00, 1.50, "Target"));
		this.data.add(new Item("Flower Pot Large", 10.00, 8.75, "Target"));
		this.data.add(new Item("Flower Pot Small", 20.00, 15.00, "Pottery Barn"));
		this.data.add(new Item("Flower Pot Large", 100.00, 82.50, "Pottery Barn"));
		this.data.add(new Item("Pizza", 5.00, 2.50, "Target"));
		this.data.add(new Item("Califlower Pizza", 10.00, 7.75, "Target"));
	}

	/**
	 * Gets Data
	 * 
	 * preconditions:  none
	 * postconditions: none
	 * @return the data
	 */
	public Collection<Item> getData() {
		return this.data;
	}
	
	/**
	 * Sets the data
	 *
	 * @preconditions: none
	 * @postconditions: none
	 * 
	 * @param data The data to update 
	 */
	public void setData(Collection<Item> data) {
		this.data = data;
	}
}
