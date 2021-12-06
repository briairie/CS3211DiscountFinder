package edu.westga.cs3211.discountFinder.model;

import java.util.Collection;
import java.util.stream.Collectors;

/** 
 * Discount Finder
 * 
 * @author	CS 3211
 * @version Fall 2021
 */
public class DiscountFinder {
	private Collection<Item> database;
	private Collection<String> sellers;
	private Collection<String> category;
	private Collection<String> location;
	
	/**
	 * 
	 * Instantiates new DiscountFinder object.
	 *
	 * preconditions:  none
	 * postconditions: none
	 */
	public DiscountFinder() {
		Database db = new Database();
		
		this.database = db.getData();
		this.sellers = db.getSellers();
		this.category = db.getCategories();
	}
	
	public DiscountFinder(Collection<Item> data) {
		this.database = data;
	}
	
	
	/**
	 * Returns list of items filtered by name, category and location
	 *
	 * preconditions: name != null && category != null && location != null
	 * postconditions: none
	 * @param name the name
	 * @return filter list
	 */
	public Collection<Item> filter(String name, String category, String location){
		Collection<Item> filtered = filterByName(name, this.database);
		filtered = this.filterBySeller(name, filtered);
		filtered = this.filterByCategory(category, filtered);
		
		return filtered;
	}
	
	private Collection<Item> filterByName(String name, Collection<Item> items){
		if(name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		
		return items
				.stream()
				.filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	private Collection<Item> filterBySeller(String seller, Collection<Item> items){
		if(seller == null) {
			throw new IllegalArgumentException("seller cannot be null");
		}
		
		return items
				.stream()
				.filter(item -> item.getSeller().toLowerCase().contains(seller.toLowerCase()))
				.collect(Collectors.toList());
	}

	private Collection<Item> filterByCategory(String category, Collection<Item> items){
		if(category == null) {
			throw new IllegalArgumentException("seller cannot be null");
		}
		
		return items
				.stream()
				.filter(item -> item.getCategory().toLowerCase().contains(category.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	/**
	 * Gets items
	 * 
	 * preconditions:  none
	 * postconditions: none
	 * @return collection of items
	 */
	public Collection<Item> getItems(){
		return this.database;
	}

	/**
	 * Gets the sellers 
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @return the sellers
	 */
	public Collection<String> getSellers() {
		return sellers;
	}

	/**
	 * Gets the category 
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @return the category
	 */
	public Collection<String> getCategory() {
		return category;
	}

	/**
	 * Gets the location 
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @return the location
	 */
	public Collection<String> getLocation() {
		return location;
	}
}
