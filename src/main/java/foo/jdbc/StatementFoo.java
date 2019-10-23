package foo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Statement java.sql.Connection.createStatement()
// Creates a Statement object for sending SQL statements to the database.
// SQL statements without parameters are normally executed using Statement objects.
// If the same SQL statement is executed many times, it may be more efficient to use a PreparedStatement object.
//
// 
// java.sql.Statement
// The object used for executing a static SQL statement and returning the results it produces. 
//
//
// ResultSet executeQuery(String sql) throws SQLException;
// int executeUpdate(String sql) throws SQLException;
// boolean execute(String sql) throws SQLException;
//
// ResultSet getResultSet() throws SQLException;
//
//
// void addBatch(String sql) throws SQLException;
// void clearBatch() throws SQLException;
// int[] executeBatch() throws SQLException;

public class StatementFoo {

	private static Logger logger = LoggerFactory.getLogger(StatementFoo.class);

	public static void main(String[] args) {

		// TODO
		String url = "jdbc:mysql://localhost/db_dev";
		String user = "root";
		String password = "";

		Connection connection = null;
		Statement statement = null;

		try {

			connection = DriverManager.getConnection(url, user, password);
			logger.info("Connection: {}", connection);

			// statement
			statement = connection.createStatement();
			logger.info("Statement: {}", statement);

			//
			statement.execute("");

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