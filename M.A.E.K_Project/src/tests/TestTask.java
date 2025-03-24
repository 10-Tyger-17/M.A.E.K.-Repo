package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Task;
import model.Task_state_Enum;

class TestTask {
	Task task;

	@BeforeEach
	void setUp() throws Exception {
		task = new Task(0, "Test", "Test", LocalDate.now(), Task_state_Enum.PENDING, "Test", "Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		task = null;
	}

	@Test
	void constructorTest() {
		assertNotNull(task);
	}

	@Test
	void gettersTest() {
		assertEquals(0, task.getId());
		assertEquals("Test", task.getTask_name());
		assertEquals("Test", task.getTask_description());
		assertEquals(LocalDate.now(), task.getDue_date());
		assertEquals(Task_state_Enum.PENDING, task.getTask_state());
		assertEquals("Test", task.getUsername());
		assertEquals("Test", task.getCategory());
	}

	@Test
	void settersTest() {
		task.setId(1);
		task.setTask_name("Test2");
		task.setTask_description("Test2");
		task.setDue_date(LocalDate.now().plusDays(1));
		task.setTask_state(Task_state_Enum.COMPLETED);
		task.setUsername("Test2");
		task.setCategory("Test2");
		assertEquals(1, task.getId());
		assertEquals("Test2", task.getTask_name());
		assertEquals("Test2", task.getTask_description());
		assertEquals(LocalDate.now().plusDays(1), task.getDue_date());
		assertEquals(Task_state_Enum.COMPLETED, task.getTask_state());
		assertEquals("Test2", task.getUsername());
		assertEquals("Test2", task.getCategory());

	}
}