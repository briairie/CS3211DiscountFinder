package edu.westga.cs3211.discountFinder.test.model.discountFinder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.Item;
import edu.westga.cs3211.discountFinder.model.Seller;

class TestFilter {

	private DiscountFinder finder;
	
	@BeforeEach
	void init() {
		ArrayList<Item> data = new ArrayList<Item>();
		
		Seller store1 = new Seller("Target", 32);
		Seller store2 = new Seller("Pottery Barn", 70);
		Seller store3 = new Seller("Kroger", 2);
		
		data.add(new Item("Flower Pot Small", 3.00, 1.50, store1,"Outdoor"));
		data.add(new Item("Flower Pot Large", 10.00, 8.75, store1,"Outdoor"));
		data.add(new Item("Small Flower Pot", 20.00, 15.00, store2,"Outdoor"));
		data.add(new Item("Pie Shelf", 100.00, 82.50, store2,"Decor"));
		data.add(new Item("Pizza", 5.00, 2.50, store3,"Grocery"));
		data.add(new Item("Califlower Pizza", 10.00, 7.75, store3,"Grocery"));
		
		finder = new DiscountFinder(data);
	}
	
	@Test
	void testNullName() {
		assertThrows(Exception.class, ()->{
			finder.filter(null, "", "", 0);	
		});
		
	}

	@Test
	void testPartialName() {
		Collection<Item> items = finder.filter("pi","","", 0);
		assertAll(() ->{
			assertEquals(3, items.size());
		});
	}

	@Test
	void testFullName() {
		Collection<Item> items = finder.filter("Califlower Pizza","","", 0);
		
		assertEquals(1, items.size());
	}
	
	@Test
	void testNullSeller() {
		assertThrows(Exception.class, ()->{
			finder.filter("", null, "", 0);	
		});
		
	}

	@Test
	void testPartialSeller() {
		Collection<Item> items = finder.filter("","Tar","", 0);
		assertAll(() ->{
			assertEquals(4, items.size());
		});
	}

	@Test
	void testFullSeller() {
		Collection<Item> items = finder.filter("","Target","", 0);
		
		assertEquals(4, items.size());
	}
	
	@Test
	void testNullCategory() {
		assertThrows(Exception.class, ()->{
			finder.filter("", "", null, 0);	
		});
		
	}

	@Test
	void testPartialCategory() {
		Collection<Item> items = finder.filter("","","door", 0);
		assertAll(() ->{
			assertEquals(3, items.size());
		});
	}

	@Test
	void testFullCategory() {
		Collection<Item> items = finder.filter("","","outdoor", 0);
		
		assertEquals(3, items.size());
	}
	
	@Test
	void testNoMatch() {
		Collection<Item> items = finder.filter("Califnia Pizza","","", 0);
		
		assertEquals(0, items.size());
	}
	
	

}
