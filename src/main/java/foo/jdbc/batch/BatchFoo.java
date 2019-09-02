package foo.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchFoo {

	private static Logger logger = LoggerFactory.getLogger(BatchFoo.class);

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

			prepareStatement.setInt(1, 101);
			prepareStatement.setString(2, "Python");
			prepareStatement.setString(3, "Py");
			prepareStatement.setInt(4, 25);
			prepareStatement.addBatch();

			prepareStatement.setInt(1, 102);
			prepareStatement.setString(2, "Ruby");
			prepareStatement.setString(3, "Ru");
			prepareStatement.setInt(4, 30);
			prepareStatement.addBatch();

			prepareStatement.setInt(1, 103);
			prepareStatement.setString(2, "Java");
			prepareStatement.setString(3, "Ja");
			prepareStatement.setInt(4, 28);
			prepareStatement.addBatch();

			int[] executeBatch = prepareStatement.executeBatch();
			for (int i : executeBatch)
				logger.info("result: {}", i);

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