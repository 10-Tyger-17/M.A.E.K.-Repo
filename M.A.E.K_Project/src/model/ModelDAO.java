package model;

import java.util.ArrayList;

/**
 * The ModelDAO interface provides methods for client authentication and task management.
 * It includes methods for logging in, signing up, retrieving categories and tasks, and managing tasks.
 */
public interface ModelDAO {
    /**
     * Authenticates a client using the provided username and password.
     *
     * @param username the username of the client
     * @param password the password of the client
     * @return the authenticated client, or null if authentication fails
     */
    public Client login(String username, String password);

    /**
     * Registers a new client with the provided details.
     *
     * @param username the username of the client
     * @param client_name the name of the client
     * @param client_password the password of the client
     * @param age the age of the client
     * @return the registered client
     */
    public Client signUp(String username, String client_name, String client_password, int age);

    /**
     * Retrieves the categories associated with the specified client.
     *
     * @param client the client whose categories are to be retrieved
     * @return a list of categories associated with the client
     */
    public ArrayList<Category> getCategories(Client client);

    /**
     * Retrieves the tasks associated with the specified client.
     *
     * @param client the client whose tasks are to be retrieved
     * @return a list of tasks associated with the client
     */
    public ArrayList<Task> getTasks(Client client);

    /**
     * Sets a new task.
     *
     * @param task the task to be set
     * @return true if the task was successfully set, false otherwise
     */
    public boolean setTask(Task task);

    /**
     * Removes the specified task.
     *
     * @param task the task to be removed
     * @return true if the task was successfully removed, false otherwise
     */
    public boolean removeTask(Task task);

    /**
     * Modifies the specified task.
     *
     * @param task the task to be modified
     * @return true if the task was successfully modified, false otherwise
     */
    public boolean modifyTask(Task task);

    /**
     * Updates the state of the specified task.
     *
     * @param task the task whose state is to be updated
     * @return true if the task state was successfully updated, false otherwise
     */
    public boolean stateTask(Task task);
}