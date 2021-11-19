package edu.westga.cs3211.discountFinder.test.model.discountFinder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.discountFinder.model.Database;
import edu.westga.cs3211.discountFinder.model.DiscountFinder;

class TestConstructor {

	@Test
	void testDefaultConstructor() {
		DiscountFinder finder = new DiscountFinder();
		Database database = new Database();
		
		assertTrue(finder.getItems().size() == database.getData().size());
	}

}
