package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Category;

/**
 * The TestCategory class provides unit tests for the Category class.
 */
class TestCategory {
    private Category category;

    /**
     * Sets up the test environment before each test.
     *
     * @throws Exception if an error occurs during setup
     */
    @BeforeEach
    void setUp() throws Exception {
        category = new Category("Test", "Test");
    }

    /**
     * Cleans up the test environment after each test.
     *
     * @throws Exception if an error occurs during teardown
     */
    @AfterEach
    void tearDown() throws Exception {
        category = null;
    }

    /**
     * Tests the constructor of the Category class.
     */
    @Test
    void constructorTest() {
        assertNotNull(category);
    }

    /**
     * Tests the getter methods of the Category class.
     */
    @Test
    void gettersTest() {
        assertEquals("Test", category.getCategory_name());
        assertEquals("Test", category.getCategory_description());
    }

    /**
     * Tests the setter methods of the Category class.
     */
    @Test
    void settersTest() {
        category.setCategory_name("Test2");
        category.setCategory_description("Test2");
        assertEquals("Test2", category.getCategory_name());
        assertEquals("Test2", category.getCategory_description());
    }
}