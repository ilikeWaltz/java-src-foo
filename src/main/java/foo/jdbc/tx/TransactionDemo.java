package foo.jdbc.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionDemo {

	private static Logger logger = LoggerFactory.getLogger(TransactionDemo.class);

	public static void main(String[] args) {

		// TODO
		String url = "";
		String user = "";
		String password = "";

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
			logger.info("Connected database successfully...");

			//
			connection.setAutoCommit(false);
			logger.info("setAutoCommit(false)");

			// Execute a query
			prepareStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?");
			prepareStatement.setInt(1, 100);
			logger.info("result: {}", prepareStatement.execute());

			//
			connection.commit();
			logger.info("connection.commit()");

		} catch (SQLException se) {
			logger.error("sql error", se);

			//
			try {
				connection.rollback();
				logger.info("connection.rollback()");
			} catch (SQLException e) {
				logger.error("error", e);
			}

		} catch (Exception e) {
			logger.error("error", e);
		} finally {

			if (prepareStatement != null) {
				try {
					prepareStatement.close();
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