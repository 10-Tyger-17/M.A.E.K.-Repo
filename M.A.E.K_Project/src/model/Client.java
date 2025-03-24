package model;

public class Client {
	private String username;
	private String client_name;
	private String client_password;
	private int age;
	
	public Client(String username, String client_name, String client_password, int age) {
		this.username = username;
		this.client_name = client_name;
		this.client_password = client_password;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_password() {
		return client_password;
	}

	public void setClient_password(String client_password) {
		this.client_password = client_password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Username: " + username + "    Name: " + client_name + "    Password: " + client_password + "    Age: " + age;
	}
}
