package model;

import java.time.LocalDate;

public class Task {
	private int id;
	private String task_name;
	private String task_description;
	private LocalDate due_date;
	private Task_state_Enum task_state;
	private String username;
	private int category_id;
	
	public Task(int id, String task_name, String task_description, LocalDate due_date, Task_state_Enum task_state,
			String username, int category_id) {
		this.id = id;
		this.task_name = task_name;
		this.task_description = task_description;
		this.due_date = due_date;
		this.task_state = task_state;
		this.username = username;
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public LocalDate getDue_date() {
		return due_date;
	}

	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}

	public Task_state_Enum getTask_state() {
		return task_state;
	}

	public void setTask_state(Task_state_Enum task_state) {
		this.task_state = task_state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task_name=" + task_name + ", task_description=" + task_description + ", due_date="
				+ due_date + ", task_state=" + task_state + ", username=" + username + ", category_id=" + category_id
				+ "]";
	}
	
	
	
	
	
	
}