package edu.westga.cs3211.discountFinder.model;

import java.text.NumberFormat;

/**
 * Item class
 * 
 * @author Brianna Irie
 * @version Fall 2021
 *
 */
public class Item implements Comparable<Item> {
	private String name;
	private double marketPrice;
	private double currentPrice;
	private Seller seller;
	private String category;
	
	/**
	 * Instantiates new Item object.
	 *
	 * preconditions: name != null  AND !name.isEmpty() AND seller != null AND !seller.isEmpty()
	 * postconditions: none
	 * @param name				the name
	 * @param marketPrice		the market price
	 * @param currentPrice		the current price
	 * @param seller			the seller
	 */
	public Item(String name, double marketPrice, double currentPrice, Seller seller,  String category) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		
		if (seller == null) {
			throw new IllegalArgumentException("Seller cannot be null");
		}
		
		if (category == null || category.isEmpty()) {
			throw new IllegalArgumentException("Category cannot be null or empty");
		}
		
		this.name = name;
		this.marketPrice = marketPrice;
		this.currentPrice = currentPrice;
		this.seller = seller;
		this.category = category;
	}

	/**
	 * Gets the name
	 *
	 * preconditions: none
	 * postconditions: none
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the Market Price
	 *
	 * preconditions: none
	 * postconditions: none
	 * @return the price
	 */
	public double getMarketPrice() {
		return this.marketPrice;
	}
	
	/**
	 * Gets the Current Price
	 *
	 * preconditions: none
	 * postconditions: none
	 * @return the price
	 */
	public double getCurrentPrice() {
		return this.currentPrice;
	}
	
	/**
	 * Gets the Seller
	 *
	 * preconditions: none
	 * postconditions: none
	 * @return the seller
	 */
	public Seller getSeller() {
		return this.seller;
	}
	
	/**
	 * Returns the discount
	 * 
	 * preconditions:  none
	 * postconditions: none
	 * @return the discount
	 */
	public double getDiscount() {
		return this.currentPrice / this.marketPrice;	
	}
	
	public String getCategory() {
		return this.category;
	}
	
	private String formatPercent(double decimal) {
		NumberFormat formatter = NumberFormat.getPercentInstance();
		return formatter.format(decimal);
	}
	
	private String formatMoney(double amount) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		return formatter.format(amount);
	}
		
	@Override
	public String toString() {
		String discount = this.formatPercent(this.getDiscount());
		String marketPriceString = this.formatMoney(this.marketPrice);
		String currentPriceString = this.formatMoney(this.currentPrice);
		return this.name + " " + marketPriceString + " " + currentPriceString + " " + discount + " " + this.seller.getName();
	}

	@Override
	public int compareTo(Item other) {
		return this.name.compareTo(other.name);
	}

	
}
