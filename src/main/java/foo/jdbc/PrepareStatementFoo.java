package foo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.sql.PreparedStatement
// An object that represents a precompiled SQL statement. 

public class PrepareStatementFoo {

	private static Logger logger = LoggerFactory.getLogger(PrepareStatementFoo.class);

	public static void main(String[] args) {

		// TODO
		String url = "";
		String user = "";
		String password = "";

		Connection connection = null;
		Statement statement = null;

		try {
			// Not necessary.
			Class.forName("com.mysql.jdbc.Driver"); // XXX mysql

			// Open a connection
			connection = DriverManager.getConnection(url, user, password);

			logger.info("Connected database successfully...");

			// Execute a query
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?)");
			logger.info("PrepareStatement: {}", prepareStatement);

			prepareStatement.setInt(1, 100);
			prepareStatement.setString(2, "C++");
			prepareStatement.setString(3, "Li");
			prepareStatement.setInt(4, 18);
			logger.info("result: {}", prepareStatement.execute());

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
