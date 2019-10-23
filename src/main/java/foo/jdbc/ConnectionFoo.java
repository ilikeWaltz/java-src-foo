package foo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// java.sql.Connection	(I)
//
// A connection (session) with a specific database. 
// SQL statements are executed and results are returned within the context of a connection. 
//
//
// ######## 
// Statement createStatement() throws SQLException;
// PreparedStatement prepareStatement(String sql) throws SQLException;
// CallableStatement prepareCall(String sql) throws SQLException;
//
//
// ######## tx
// void setAutoCommit(boolean autoCommit) throws SQLException;
// void commit() throws SQLException;
// void rollback() throws SQLException;
//
//
// void setTransactionIsolation(int level) throws SQLException;

public class ConnectionFoo {

	private static Logger logger = LoggerFactory.getLogger(ConnectionFoo.class);

	public static void main(String[] args) {

		// TODO
		String url = "jdbc:mysql://localhost/database_dev";
		String user = "root";
		String password = "";

		Connection connection = null;

		try {

			// Not necessary.
			Class.forName("com.mysql.jdbc.Driver"); // XXX mysql

			// get connection
			connection = DriverManager.getConnection(url, user, password);
			logger.info("Connection: {}", connection);

			// Connection
			boolean readOnly = connection.isReadOnly();
			logger.info("readOnly: {}", readOnly);

			//
			Properties clientInfo = connection.getClientInfo();
			Set<Entry<Object, Object>> entrySet = clientInfo.entrySet();
			for (Entry<Object, Object> entry : entrySet)
				logger.info("client info, k-v:\t{}: {}", entry.getKey(), entry.getValue());

			//
			int transactionIsolation = connection.getTransactionIsolation();
			logger.info("transactionIsolation: {}", transactionIsolation);

			//
			String schema = connection.getSchema();
			logger.info("schema: {}", schema);

		} catch (SQLException se) {
			logger.error("sql error", se);
		} catch (Exception e) {
			logger.error("error", e);
		} finally {

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