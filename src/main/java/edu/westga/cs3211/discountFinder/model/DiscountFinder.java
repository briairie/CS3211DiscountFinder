package edu.westga.cs3211.discountFinder.model;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.ArrayList;

/** 
 * Discount Finder
 * 
 * @author	CS 3211
 * @version Fall 2021
 */
public class DiscountFinder {
	private Collection<Item> database;
	
	/**
	 * 
	 * Instantiates new DiscountFinder object.
	 *
	 * preconditions:  none
	 * postconditions: none
	 */
	public DiscountFinder() {
		this.database = new ArrayList<Item>();
	}
	
	public DiscountFinder(Collection<Item> data) {
		this.database = data;
	}
	
	
	/**
	 * Returns list of items filtered by name
	 *
	 * preconditions: name != null
	 * postconditions: none
	 * @param name the name
	 * @return filter list
	 */
	public Collection<Item> filter(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		
		return this.database
				.stream()
				.filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()))
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
}
