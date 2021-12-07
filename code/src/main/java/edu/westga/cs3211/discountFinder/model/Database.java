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
	private Collection<Seller> sellers;
	private Collection<String> categories;

	/**
	 * Instantiates new Database object.
	 *
	 * preconditions:  none
	 * postconditions: none
	 */
	public Database() {
		this.sellers = new ArrayList<Seller>();

		Seller store1 = new Seller("Target", 32);
		Seller store2 = new Seller("Pottery Barn", 70);
		Seller store3 = new Seller("Kroger", 2);

		this.sellers.add(store1);
		this.sellers.add(store2);
		this.sellers.add(store3);

		this.data = new ArrayList<Item>();
		this.data.add(new Item("Flower Pot Small", 3.00, 1.50, store1, "Decor"));
		this.data.add(new Item("Flower Pot Large", 10.00, 8.75, store1, "Outdoor"));
		this.data.add(new Item("Flower Pot Small", 20.00, 15.00, store2, "Decor"));
		this.data.add(new Item("Flower Pot Large", 100.00, 82.50, store2, "Outdoor"));
		this.data.add(new Item("Pizza", 5.00, 2.50, store3, "Grocery"));
		this.data.add(new Item("Califlower Pizza", 10.00, 7.75, store3, "Grocery"));
		this.data.add(new Item("Key Chain", 3.00, 1.50, store1, "Misc"));
		this.data.add(new Item("Flower Pot Large", 10.00, 8.75, store1, "Outdoor"));
		this.data.add(new Item("Key Chain", 20.00, 15.00, store2, "Misc"));
		this.data.add(new Item("11 Wick Candle", 100.00, 82.50, store2, "Decor"));
		this.data.add(new Item("Applesauce", 5.00, 2.50, store3, "Grocery"));
		this.data.add(new Item("Hot Cheetos", 10.00, 7.75, store3, "Grocery"));


		this.categories = new ArrayList<String>();
		for (Item item : this.data) {
			String category = item.getCategory();

			if (!this.categories.contains(category)) {
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
	public Collection<Seller> getSellers() {
		return this.sellers;
	}

	/**
	 * Gets Categories
	 *
	 * preconditions:  none
	 * postconditions: none
	 * @return the categories
	 */
	public Collection<String> getCategories() {
		return this.categories;
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
