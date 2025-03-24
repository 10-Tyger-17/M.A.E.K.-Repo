package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Client;

class TestClient {
	Client client;
	
	@BeforeEach
	void setUp() throws Exception {
		client = new Client("Test", "Test", "Test", 23);
	}

	@AfterEach
	void tearDown() throws Exception {
		client = null;
	}
	
	@Test
	void constructorTest() {
		assertNotNull(client);
	}
	
	@Test
	void gettersTest() {
		assertEquals("Test", client.getUsername());
		assertEquals("Test", client.getClient_name());
		assertEquals("Test", client.getClient_password());
		assertEquals(23, client.getAge());
	}
	
	@Test
	void settersTest() {
		client.setUsername("Test2");
		client.setClient_name("Test2");
		client.setClient_password("Test2");
		client.setAge(24);
		assertEquals("Test2", client.getUsername());
		assertEquals("Test2", client.getClient_name());
		assertEquals("Test2", client.getClient_password());
		assertEquals(24, client.getAge());
	}
}