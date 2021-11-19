package edu.westga.cs3211.discountFinder.test.model.item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.Item;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(Exception.class, ()->{
			new Item(null, 2, 3, "Target");
		});
	}
	
	@Test
	void testNullSeller() {
		assertThrows(Exception.class, ()->{
			new Item("cake", 2, 3, null);
		});
	}
	
	@Test
	void testEmptyName() {
		assertThrows(Exception.class, ()->{
			new Item("", 2, 3, "Target");
		});
	}
	
	@Test
	void testEmptySeller() {
		assertThrows(Exception.class, ()->{
			new Item("cake", 2, 3, "");
		});
	}
	
	@Test
	void testValidItem() {
		Item item = new Item("Carrot", 1, .50, "Kroger");
		assertAll(()->{
			assertEquals("Carrot", item.getName());
			assertEquals(1, item.getMarketPrice());
			assertEquals(.50, item.getCurrentPrice());
			assertEquals("Kroger", item.getSeller());
			assertEquals(.5, item.getDiscount(), 1);
		});
	}

}
