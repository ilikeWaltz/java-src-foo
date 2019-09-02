package foo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.sql.Statement
// The object used for executing a static SQL statement and returning the results it produces. 

public class StatementFoo {

	private static Logger logger = LoggerFactory.getLogger(StatementFoo.class);

	public static void main(String[] args) {

		// TODO
		String url = "jdbc:mysql://localhost/database_dev";
		String user = "root";
		String password = "";

		Connection connection = null;
		Statement statement = null;

		try {

			// Not necessary.
			Class.forName("com.mysql.jdbc.Driver"); // XXX mysql

			// connection
			connection = DriverManager.getConnection(url, user, password);
			logger.info("Connection: {}", connection);

			// statement
			statement = connection.createStatement();
			logger.info("Statement: {}", statement);

			//

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