package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Category;

class TestCategory {
	Category category;
	
	@BeforeEach
	void setUp() throws Exception {
		category = new Category("Test", "Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		category = null;
	}

	@Test
	void constructorTest() {
		assertNotNull(category);
	}
	
	@Test
	void gettersTest() {
		assertEquals("Test", category.getCategory_name());
		assertEquals("Test", category.getCategory_description());
	}
	
	@Test
	void settersTest() {
		category.setCategory_name("Test2");
		category.setCategory_description("Test2");
		assertEquals("Test2", category.getCategory_name());
		assertEquals("Test2", category.getCategory_description());
	}
}