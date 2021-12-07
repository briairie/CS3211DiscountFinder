package edu.westga.cs3211.discountFinder.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/** 
 * Discount Finder
 * 
 * @author	CS 3211
 * @version Fall 2021
 */
public class DiscountFinder {
	private Collection<Item> database;
	private Collection<Seller> sellers;
	private Collection<String> category;
	private Collection<String> location;
	private String favoriteSeller;
	
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
	 * @param seller the seller
	 * @param category the category
	 * @param distance the distance
	 * @return filter list
	 */
	public Collection<Item> filter(String name, String seller, String category, double distance){
		Collection<Item> filtered = filterByName(name, this.database);
		filtered = this.filterBySeller(seller, filtered);
		filtered = this.filterByCategory(category, filtered);
		filtered = this.filterByDistance(distance, filtered);
		
		filtered = this.sortItems(filtered);
		
		return filtered;
	}
	
	private Collection<Item> filterByName(String name, Collection<Item> items){	
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
				.filter(item -> item.getSeller().getName().toLowerCase().contains(seller.toLowerCase()))
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
	
	private Collection<Item> filterByDistance(double distance, Collection<Item> items){	
		if(distance == 0) {
			return items;
		}
		return items
				.stream()
				.filter(item -> item.getSeller().getClosetStoreDistance() <= distance)
				.collect(Collectors.toList());
	}
	
	/**
	 * Gets items
	 * 
	 * preconditions:  none
	 * postconditions: none
	 * @return collection of items
	 */
	public Collection<Item> getItems() {
		return this.database;
	}

	/**
	 * Gets the seller names
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @return the sellers
	 */
	public Collection<String> getSellers() {
		return sellers.stream().map(Seller::getName).collect(Collectors.toList());
	}

	/**
	 * Gets the category 
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @return the categories
	 */
	public Collection<String> getCategories() {
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

	/**
	 * Sets the favoriteSeller 
	 *
	 * preconditions:  none
	 * postconditions: none
	 *
	 * @param favoriteSeller the favoriteSeller to set
	 */
	public void setFavoriteSeller(String favoriteSeller) {
		this.favoriteSeller = favoriteSeller;
	}
	
	private Collection<Item> sortItems(Collection<Item> items) {
		if(this.favoriteSeller == null || this.favoriteSeller.isEmpty()) {
			Collections.sort((List<Item>) items);
			return items;
		}else {
			 List<Item> favoriteItems = items
			 	.stream()
				.filter(item -> item.getSeller().getName().toLowerCase().contains(this.favoriteSeller.toLowerCase()))
				.collect(Collectors.toList());
			 
			 List<Item> restOfItems = items
					 	.stream()
						.filter(item -> !item.getSeller().getName().toLowerCase().contains(this.favoriteSeller.toLowerCase()))
						.collect(Collectors.toList());
			 
			 Collections.sort(favoriteItems);
			 Collections.sort(restOfItems);
			 
			 favoriteItems.addAll(restOfItems);
			 
			 return favoriteItems;
			 
		}
	}
	
	

	
}
