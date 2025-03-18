package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public ImplementDB() {
		this.configFile = ResourceBundle.getBundle("configClase");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

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

	@Override
	public Client login(String username, String password) {
		Cliente client = null;
		
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
}