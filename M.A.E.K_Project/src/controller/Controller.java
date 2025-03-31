package controller;

import java.util.ArrayList;

import model.Category;
import model.Client;
import model.ImplementDB;
import model.ModelDAO;
import model.Task;
import view.WindowLogin;

/**
 * The Controller class handles the interaction between the view and the model.
 * It manages user input and updates the model accordingly.
 */
public class Controller {

    private ModelDAO dao = new ImplementDB();

    /**
     * Displays the login screen.
     */
    public void showScreen() {
        WindowLogin frameLogin = new WindowLogin(this);
        frameLogin.setVisible(true);
    }

    /**
     * Authenticates a user with the given username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the authenticated Client object
     */
    public Client login(String username, String password) {
        return dao.login(username, password);
    }

    /**
     * Registers a new user with the given details.
     *
     * @param username the username of the new user
     * @param client_name the name of the new user
     * @param client_password the password of the new user
     * @param age the age of the new user
     * @return the registered Client object
     */
    public Client signUp(String username, String client_name, String client_password, int age) {
        return dao.signUp(username, client_name, client_password, age);
    }

    /**
     * Retrieves the list of categories for the given client.
     *
     * @param client the client whose categories are to be retrieved
     * @return the list of categories
     */
    public ArrayList<Category> getCategories(Client client) {
        return dao.getCategories(client);
    }

    /**
     * Retrieves the list of tasks for the given client.
     *
     * @param client the client whose tasks are to be retrieved
     * @return the list of tasks
     */
    public ArrayList<Task> getTasks(Client client) {
        return dao.getTasks(client);
    }

    /**
     * Adds a new task.
     *
     * @param task the task to be added
     * @return true if the task was added successfully, false otherwise
     */
    public boolean setTask(Task task) {
        return dao.setTask(task);
    }

    /**
     * Removes an existing task.
     *
     * @param task the task to be removed
     * @return true if the task was removed successfully, false otherwise
     */
    public boolean removeTask(Task task) {
        return dao.removeTask(task);
    }

    /**
     * Modifies an existing task.
     *
     * @param task the task to be modified
     * @return true if the task was modified successfully, false otherwise
     */
    public boolean modifyTask(Task task) {
        return dao.modifyTask(task);
    }

    /**
     * Updates the state of a task.
     *
     * @param task the task whose state is to be updated
     * @return true if the task state was updated successfully, false otherwise
     */
    public boolean stateTask(Task task) {
        return dao.stateTask(task);
    }
}