package controller;

import java.util.ArrayList;

import model.Client;
import model.ImplementDB;
import model.ModelDAO;
import model.Task;
import visual.WindowLogin;

public class Controller {
	
	ModelDAO dao = new ImplementDB();
	
	public void showScreen() {
		WindowLogin frameLogin = new WindowLogin(this);
		frameLogin.setVisible(true);
	}
	public Client login(String username, String password) {
		return dao.login(username, password);
	}
	public Client signUp(String username, String client_name, String client_password, int age) {
		return dao.signUp(username, client_name, client_password, age);
	}
	public ArrayList<Task> getTasks(Client client){
		return dao.getTasks(client);
	}
	public boolean setTask(Task task){
		return dao.setTask(task);
	}
	public boolean removeTask(Task task){
		return dao.removeTask(task);
	}
	public boolean modifyTask(Task task){
		return dao.modifyTask(task);
	}
	public boolean stateTask(Task task){
		return dao.stateTask(task);
	}
}
