/**
 * 
 */
package edu.westga.cs3211.discountFinder.test.model.discountFinder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.Item;
import edu.westga.cs3211.discountFinder.model.Seller;

/**
 * @author Brianna Irie
 * @version Fall 2021
 *
 */
class TestSetFavoriteSeller {

private DiscountFinder finder;
	
	@BeforeEach
	void init() {
		finder = new DiscountFinder();
	}
	
	@Test
	void testSetFavorite() {
		String seller = "Kroger";
		finder.setFavoriteSeller(seller);
		List<Item> items = (List<Item>) finder.filter("", "", "", 0);
		assertAll(() ->{
			assertEquals(seller, items.get(0).getSeller().getName());
			assertEquals(seller, items.get(1).getSeller().getName());
			assertEquals(seller, items.get(2).getSeller().getName());
			assertEquals(seller, items.get(3).getSeller().getName());
		});
	}
	
	

}
