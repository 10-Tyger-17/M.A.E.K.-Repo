package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Client;

/**
 * The TestClient class provides unit tests for the Client class.
 */
class TestClient {
    private Client client;

    /**
     * Sets up the test environment before each test.
     *
     * @throws Exception if an error occurs during setup
     */
    @BeforeEach
    void setUp() throws Exception {
        client = new Client("Test", "Test", "Test", 23);
    }

    /**
     * Cleans up the test environment after each test.
     *
     * @throws Exception if an error occurs during teardown
     */
    @AfterEach
    void tearDown() throws Exception {
        client = null;
    }

    /**
     * Tests the constructor of the Client class.
     */
    @Test
    void constructorTest() {
        assertNotNull(client);
    }

    /**
     * Tests the getter methods of the Client class.
     */
    @Test
    void gettersTest() {
        assertEquals("Test", client.getUsername());
        assertEquals("Test", client.getClient_name());
        assertEquals("Test", client.getClient_password());
        assertEquals(23, client.getAge());
    }

    /**
     * Tests the setter methods of the Client class.
     */
    @Test
    void settersTest() {
        client.setUsername("Test2");
        client.setClient_password("Test2");
        client.setAge(24);
        assertEquals("Test2", client.getUsername());
        assertEquals("Test2", client.getClient_name());
        assertEquals("Test2", client.getClient_password());
        assertEquals(24, client.getAge());
    }
}
