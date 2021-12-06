package edu.westga.cs3211.discountFinder.model;

import java.text.NumberFormat;

/**
 * Item class
 * 
 * @author Brianna Irie
 * @version Fall 2021
 *
 */
public class Item {
	private String name;
	private double marketPrice;
	private double currentPrice;
	private String seller;
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
	public Item(String name, double marketPrice, double currentPrice, String seller) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		
		if(seller == null || seller.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		
		this.name = name;
		this.marketPrice = marketPrice;
		this.currentPrice = currentPrice;
		this.seller = seller;
	}
	
	/**
	 * Instantiates new Item object.
	 *
	 * preconditions: name != null  AND !name.isEmpty() AND seller != null AND !seller.isEmpty()
	 * postconditions: none
	 * @param name				the name
	 * @param marketPrice		the market price
	 * @param currentPrice		the current price
	 * @param seller			the seller
	 * @param category 			the category
	 */
	public Item(String name, double marketPrice, double currentPrice, String seller, String category) {
		this(name, marketPrice, currentPrice, seller);
		
		if(category != null) {
			this.category = category;
		} else {
			this.category = "";
		}
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
		return currentPrice;
	}
	
	/**
	 * Gets the Seller
	 *
	 * preconditions: none
	 * postconditions: none
	 * @return the seller
	 */
	public String getSeller() {
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
		return this.name + " " + marketPriceString + " " + currentPriceString + " " + discount + " " + this.seller;
	}

	
}
