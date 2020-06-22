package foo.jdbc.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import foo.jdbc.Constants;

public class TransactionFoo {

	private static Logger logger = LoggerFactory.getLogger(TransactionFoo.class);

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
			logger.info("Connection: {}", connection);

			// XXX
			connection.setAutoCommit(false);
			logger.info("setAutoCommit(false)");

			// Creates a PreparedStatement
			preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?");

			// do sth
			preparedStatement.setInt(1, 100);
			logger.info("result: {}", preparedStatement.execute());

			// XXX
			connection.commit();
			logger.info("connection.commit()");

		} catch (SQLException se) {
			logger.error("sql error", se);

			// XXX
			try {
				connection.rollback();
				logger.info("connection.rollback()");
			} catch (SQLException e) {
				logger.error("error", e);
			}

		} catch (Exception e) {
			logger.error("error", e);
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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