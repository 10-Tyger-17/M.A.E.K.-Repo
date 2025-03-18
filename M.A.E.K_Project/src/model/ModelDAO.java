package model;

import java.util.ArrayList;

public interface ModelDAO {
	public Client login(String username, String password);
	public Client signUp(String username, String client_name, String client_password, int age);
	public ArrayList<Task> getTasks(Client client);
	
}