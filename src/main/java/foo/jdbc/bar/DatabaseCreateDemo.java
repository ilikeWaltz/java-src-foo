package foo.jdbc.bar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseCreateDemo {

	private static Logger logger = LoggerFactory.getLogger(DatabaseCreateDemo.class);

	public static void main(String[] args) {

		// TODO
		String url = "";
		String user = "";
		String password = "";

		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
			logger.info("Database connected successfully...");

			// Execute a query
			statement = connection.createStatement();
			String sql = "CREATE DATABASE IF NOT EXISTS jdbc_db";

			int executeUpdate = statement.executeUpdate(sql);
			logger.info("Database created result: {}", executeUpdate);

		} catch (SQLException se) {
			logger.error("sql error", se);
		} catch (Exception e) {
			logger.error("error", e);
		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException se) {
					logger.error("error", se);
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException se) {
					logger.error("error", se);
				}
			}
		}
		logger.info("Goodbye!");
	}
}