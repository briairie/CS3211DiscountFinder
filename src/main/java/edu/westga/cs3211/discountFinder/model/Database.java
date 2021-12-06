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
	private Collection<String> sellers;
	private Collection<String> categories;
	
	/**
	 * Instantiates new Database object.
	 *
	 * preconditions:  none
	 * postconditions: none
	 */
	public Database() {
		this.data = new ArrayList<Item>();
		this.data.add(new Item("Flower Pot Small", 3.00, 1.50, "Target", "Outdoor"));
		this.data.add(new Item("Flower Pot Large", 10.00, 8.75, "Target", "Outdoor"));
		this.data.add(new Item("Flower Pot Small", 20.00, 15.00, "Pottery Barn","Decor"));
		this.data.add(new Item("Flower Pot Large", 100.00, 82.50, "Pottery Barn","Decor"));
		this.data.add(new Item("Pizza", 5.00, 2.50, "Target", "Grocery"));
		this.data.add(new Item("Califlower Pizza", 10.00, 7.75, "Target","Grocery"));
		
		this.sellers = new ArrayList<String>();
		this.categories = new ArrayList<String>();
		for (Item item : this.data) {
			String seller = item.getSeller();
			String category = item.getCategory();
			
			if(!this.sellers.contains(seller)) {
				this.sellers.add(seller);
			}
			
			if(!this.categories.contains(category)) {
				this.categories.add(category);
			}
		}
	}
	
	/**
	 * Gets Sellers
	 * 
	 * preconditions:  none
	 * postconditions: none
	 * @return the sellers
	 */
	public Collection<String> getSellers() {
		return sellers;
	}

	/**
	 * Gets Categories
	 * 
	 * preconditions:  none
	 * postconditions: none
	 * @return the categories
	 */
	public Collection<String> getCategories() {
		return categories;
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
}
