package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

public class ImplementDB implements ModelDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet result;

	private ResourceBundle configFile;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	final String SQLLOGIN = "SELECT * FROM client WHERE username = ? && client_password = ?;";
	final String SQLSIGNUP = "CALL SIGNUP(?,?,?,?);";
	final String SQLCATEGORIES = "SELECT * FROM category WHERE category_name IN (SELECT category_name FROM task WHERE username = ?);";
	final String SQLTASKS = "SELECT * FROM task WHERE username = ?;";
	final String SQLSETTASK = "INSERT INTO task (task_name, task_description, due_date, task_state, username, category_name) VALUES (?, ?, ?, ?, ?, ?);";
	final String SQLREMOVETASK = "DELETE FROM task WHERE id = ?;";
	final String SQLSTATETASK = "UPDATE task SET task_state = ? WHERE id = ?;";
	final String SQLALLCATEGORIES = "SELECT * FROM category WHERE category_name = ?;";
	final String SQLSETCATEGORY = "INSERT INTO category VALUES (?, ?);";

	/**
	 * This method is the constructor of the class ImplementDB
	 */

	public ImplementDB() {
		this.configFile = ResourceBundle.getBundle("configs.configClase");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	/**
	 * This method opens the connection to the database
	 */

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error opening the DB");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method closes the connection to the database
	 */

	private void closeConnection() {
		try {
			if (stmt != null) stmt.close();
			if (con != null) con.close();
			if (result != null) result.close();
		} catch (SQLException e) {
			System.out.println("Error closing the DB");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method checks the user name and passwords in the database to see if they correspond with a user.
	 * @param username This is the user name to look for
	 * @param password This is the password to look for
	 * @return client who's user name and password corresponds with the parameters
	 */

	@Override
	public Client login(String username, String password) {
		Client client = null;

		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLLOGIN);
			stmt.setString(1, username);
			stmt.setString(2, password);
			result = stmt.executeQuery();

			if (result.next()) {
				client = new Client(result.getString(1), result.getString(2), result.getString(3), result.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println("Error login: " + e.getMessage());
		} finally {
			this.closeConnection();
		}

		return client;
	}

	/**
	 * This method adds a new user to the database, managing all exception and errors.
	 * @param username This is the user name of the user
	 * @param client_name This is the real name of the user
	 * @param client_password This is the password of the user
	 * @param age The current age of the client
	 * @return the newly created client
	 */

	@Override
	public Client signUp(String username, String client_name, String client_password, int age) {
		Client client = null;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLSIGNUP);
			stmt.setString(1, username);
			stmt.setString(2, client_name);
			stmt.setString(3, client_password);
			stmt.setInt(4, age);
			result = stmt.executeQuery();
			result.next();

			if (result.getString("Message").contains("New client added")) {
				client = new Client(username, client_name, client_password, age);
			}
		} catch (SQLException e) {
			System.out.println("Error signUp: " + e.getMessage());
		} finally {
			this.closeConnection();
		}

		return client;
	}

	/**
	 * This method gets all the categories of a client from the database and sorts them.
	 * @param client This is the client to get the categories from
	 * @return an array list of categories
	 */

	@Override
	public ArrayList<Category> getCategories(Client client) {
		ArrayList<Category> categories = new ArrayList<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLCATEGORIES);
			stmt.setString(1, client.getUsername());
			result = stmt.executeQuery();

			while (result.next()) {
				categories.add(new Category(result.getString(1), result.getString(2)));
			}

			categories.sort(Comparator.comparing(Category::getCategory_name));
		} catch (SQLException e) {
			System.out.println("Error getCategories: " + e.getMessage());
		} finally {
			this.closeConnection();
		}

		return categories;
	}

	/**
	 * This method gets all the tasks of a client from the database and sorts them.
	 * @param client This is the client to get the tasks from
	 * @return an array list of tasks
	 */

	@Override
	public ArrayList<Task> getTasks(Client client) {
		ArrayList<Task> tasks = new ArrayList<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLTASKS);
			stmt.setString(1, client.getUsername());
			result = stmt.executeQuery();

			while (result.next()) {
				tasks.add(new Task(result.getInt(1), result.getString(2), result.getString(3), result.getDate(4).toLocalDate(), Task_state_Enum.valueOf(result.getString(5)), result.getString(6), result.getString(7)));
			}

			tasks.sort(Comparator.comparing(Task::getDue_date));
		} catch (SQLException e) {
			System.out.println("Error getTasks: " + e.getMessage());
		} finally {
			this.closeConnection();
		}

		return tasks;
	}

	/**
	 * This method adds a new task to the database, managing all exception and errors.
	 * @param task The new task which needs to be added
	 * @return whether there was an error or not during the process
	 */

	@Override
	public boolean setTask(Task task) {
		boolean error = false;

		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLALLCATEGORIES);
			stmt.setString(1, task.getCategory());
			ResultSet result = stmt.executeQuery();

			if (!result.next()) {
				stmt = con.prepareStatement(SQLSETCATEGORY);
				stmt.setString(1, task.getCategory());
				stmt.setString(2, task.getCategory());

				if (stmt.executeUpdate() == 0) {
					error = true;
				}
			}

			stmt = con.prepareStatement(SQLSETTASK);
			stmt.setString(1, task.getTask_name());
			stmt.setString(2, task.getTask_description());
			stmt.setDate(3, Date.valueOf(task.getDue_date()));
			stmt.setString(4, task.getTask_state().value());
			stmt.setString(5, task.getUsername());
			stmt.setString(6, task.getCategory());

			if (stmt.executeUpdate() == 0) {
				error = true;
			}

		} catch (SQLException e) {
			System.out.println("Error setTask: " + e.getMessage());
			error = true;
		} finally {
			this.closeConnection();
		}

		return error;
	}

	/**
	 * This method deletes a task to the database, managing all exception and errors.
	 * @param task The task which should be deleted
	 * @return whether there was an error or not during the process
	 */

	@Override
	public boolean removeTask(Task task) {
		boolean error = false;

		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLREMOVETASK);
			stmt.setInt(1,task.getId());

			if (stmt.executeUpdate() == 0) {
				error = true;
			}

		} catch (SQLException e) {
			System.out.println("Error removeTask: " + e.getMessage());
			error = true;
		} finally {
			this.closeConnection();
		}

		return error;
	}

	/**
	 * This method modifies a task to the database, managing all exception and errors.
	 * @param task The task which should be modified in the database
	 * @return whether there was an error or not during the process
	 */

	@Override
	public boolean modifyTask(Task task) {
		boolean error = false;
		this.openConnection();

		try {
			StringBuilder sql = new StringBuilder("UPDATE task SET ");
			ArrayList<Object> params = new ArrayList<>();

			if (task.getTask_name() != null && !task.getTask_name().isEmpty()) {
				sql.append("task_name = ?, ");
				params.add(task.getTask_name());
			}

			if (task.getTask_description() != null && !task.getTask_description().isEmpty()) {
				sql.append("task_description = ?, ");
				params.add(task.getTask_description());
			}

			if (task.getTask_state() != null) {
				sql.append("task_state = ?, ");
				params.add(task.getTask_state().value());
			}

			if (task.getCategory() != null && !task.getCategory().isEmpty()) {
				sql.append("category_name = ?, ");
				params.add(task.getCategory());
			}

			if (task.getDue_date() != null && !String.valueOf(task.getDue_date()).isEmpty()) {
				sql.append("due_date = ?, ");
				params.add(task.getDue_date());
			}

			if (!params.isEmpty()) {
				sql.setLength(sql.length() - 2);
				sql.append(" WHERE id = ?");
				params.add(task.getId());

				stmt = con.prepareStatement(sql.toString());

				for (int i = 0; i < params.size(); i++) {
					stmt.setObject(i + 1, params.get(i));
				}

				if (stmt.executeUpdate() == 0) {
					error = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Error modifyTask: " + e.getMessage());
			error = true;
		} finally {
			this.closeConnection();
		}

		return error;
	}

	/**
	 * This method checks the state of a task, managing all exception and errors.
	 * @param task The task which should be checked
	 * @return whether there was an error or not during the process
	 */

	@Override
	public boolean stateTask(Task task) {
		boolean error = false;

		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLSTATETASK);
			stmt.setString(1, Task_state_Enum.COMPLETED.value());
			stmt.setInt(2, task.getId());

			if (stmt.executeUpdate() == 0) {
				error = true;
			}

		} catch (SQLException e) {
			System.out.println("Error stateTask: " + e.getMessage());
			error = true;
		} finally {
			this.closeConnection();
		}

		return error;
	}
}