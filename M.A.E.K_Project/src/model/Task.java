package model;

import java.time.LocalDate;

/**
 * The Task class represents a task with an ID, name, description, due date, state, username, and category.
 * It provides methods to get and set these attributes.
 */
public class Task {
    private int id;
    private String task_name;
    private String task_description;
    private LocalDate due_date;
    private Task_state_Enum task_state;
    private String username;
    private String category;

    /**
     * Constructs a new Task with the specified attributes.
     *
     * @param id the ID of the task
     * @param task_name the name of the task
     * @param task_description the description of the task
     * @param due_date the due date of the task
     * @param task_state the state of the task
     * @param username the username associated with the task
     * @param category the category of the task
     */
    public Task(int id, String task_name, String task_description, LocalDate due_date, Task_state_Enum task_state,
                String username, String category) {
        this.id = id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.due_date = due_date;
        this.task_state = task_state;
        this.username = username;
        this.category = category;
    }

    /**
     * Returns the ID of the task.
     *
     * @return the task ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the task.
     *
     * @param id the new task ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the task.
     *
     * @return the task name
     */
    public String getTask_name() {
        return task_name;
    }

    /**
     * Sets the name of the task.
     *
     * @param task_name the new task name
     */
    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    /**
     * Returns the description of the task.
     *
     * @return the task description
     */
    public String getTask_description() {
        return task_description;
    }

    /**
     * Sets the description of the task.
     *
     * @param task_description the new task description
     */
    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    /**
     * Returns the due date of the task.
     *
     * @return the due date
     */
    public LocalDate getDue_date() {
        return due_date;
    }

    /**
     * Sets the due date of the task.
     *
     * @param due_date the new due date
     */
    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    /**
     * Returns the state of the task.
     *
     * @return the task state
     */
    public Task_state_Enum getTask_state() {
        return task_state;
    }

    /**
     * Sets the state of the task.
     *
     * @param task_state the new task state
     */
    public void setTask_state(Task_state_Enum task_state) {
        this.task_state = task_state;
    }

    /**
     * Returns the username associated with the task.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username associated with the task.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the category of the task.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the task.
     *
     * @param category the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return a string representation of the task
     */
    @Override
    public String toString() {
        return "Name: " + task_name + "    Description: " + task_description + "    Due date: " + due_date + "    State: " + task_state + "    Category: " + category;
    }
}
