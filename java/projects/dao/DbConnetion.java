/**
 * 
 */
package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import recipes.exception.DbException;

/**
 * @author alejandraorcutt
 *
 */
public class DbConnetion {

	// create constants
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	// create a method to create a new connection in JDBC
	// add parameters (URL,

	public static Connection getConnection() {

		String url =
				String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", 
						HOST, PORT, SCHEMA, USER, PASSWORD);

		System.out.println("Connecting to URL: " + url);

		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("Succesfully obtained connection!");
			return connection;

		} catch (SQLException e) {
			System.out.println("Could not connect :(");
			throw new DbException(e);
		}

	}

}
