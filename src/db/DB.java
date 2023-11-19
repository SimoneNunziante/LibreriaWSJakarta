package db;

import java.sql.*;

public class DB {

	private static Connection connection;
	
	public static Connection getDb() throws Exception {
		
		if(connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/libreria","root","root");
		}
		
		return connection;
	}
	
	public static Statement getStmt() throws Exception {
		return getDb().createStatement();
	}
	
	public static PreparedStatement getPrepareStatement(String query) throws Exception {
		return getDb().prepareStatement(query);
	}
	
	public static PreparedStatement getPreparedStatement(String query) throws Exception {
		return getDb().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	} 
	
}
