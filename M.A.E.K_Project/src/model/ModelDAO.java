package model;

import java.util.ArrayList;

public interface ModelDAO {
	public Client login(String username, String password);
	public Client signUp(String username, String client_name, String client_password, int age);
	public ArrayList<Category> getCategories(Client client);
	public ArrayList<Task> getTasks(Client client);
	public boolean setTask(Task task);
	public boolean removeTask(Task task);
	public boolean modifyTask(Task task);
	public boolean stateTask(Task task);

}