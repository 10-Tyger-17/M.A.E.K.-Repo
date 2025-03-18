package model;

import java.util.ArrayList;

public interface ModelDAO {
	public Client login(String username, String password);
	public ArrayList<Task> getTasks(Client client);
}