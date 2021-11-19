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

class TestFilter {

	private DiscountFinder finder;
	@BeforeEach
	void init() {
		ArrayList<Item> data = new ArrayList<Item>();
		data.add(new Item("Flower Pot Small", 3.00, 1.50, "Target"));
		data.add(new Item("Flower Pot Large", 10.00, 8.75, "Target"));
		data.add(new Item("Small Flower Pot", 20.00, 15.00, "Pottery Barn"));
		data.add(new Item("Pie Shelf", 100.00, 82.50, "Pottery Barn"));
		data.add(new Item("Pizza", 5.00, 2.50, "Target"));
		data.add(new Item("Califlower Pizza", 10.00, 7.75, "Target"));
		
		finder = new DiscountFinder(data);
	}
	
	@Test
	void testNullName() {
		assertThrows(Exception.class, ()->{
			finder.filter(null);	
		});
		
	}

	@Test
	void testPartialName() {
		Collection<Item> items = finder.filter("pi");
		assertAll(() ->{
			assertEquals(3, items.size());
		});
	}

	@Test
	void testFullName() {
		Collection<Item> items = finder.filter("Califlower Pizza");
		
		assertEquals(1, items.size());
	}
	
	@Test
	void testNoMatch() {
		Collection<Item> items = finder.filter("Califnia Pizza");
		
		assertEquals(0, items.size());
	}
	
	

}
