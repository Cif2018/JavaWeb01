package com.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringJoiner;

public class AddDataToDB {

	public void add(String dbPath, String dbName, String theTable, String[] theTableColumns, String[] toInsert)
			throws ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
//      try {
//			DriverManager.registerDriver(new org.sqlite.JDBC());
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		Connection connection = null;

		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath + dbName);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			StringJoiner ins = new StringJoiner(",");
			for (String i : toInsert) {
				ins.add("'" + i + "'");
			}
			statement.executeUpdate("insert into " + theTable + " values (" + ins + ")");

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e.getMessage() + " ! 74 ! ");
			}
		}

	}

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String[] theTableColumns = new String[2];
		theTableColumns[0] = "user";
		theTableColumns[1] = "password";

		String[] addNew = new String[2];
		addNew[0] = "cip";
		addNew[1] = "cippass";

		AddDataToDB adtdb = new AddDataToDB();
//		adtdb.add("C:\\Users\\userT\\eclipse-JEE-workspace\\JavaWeb01\\WebContent\\WEB-INF\\DB\\", "usersDB",
//				"usersAndPasswords", theTableColumns, addNew);
		
		adtdb.add("C:\\Users\\userT\\eclipse-JEE-workspace\\JavaWeb01\\WebContent\\WEB-INF\\DB\\", "usersDB",
				"usersAndPasswords", theTableColumns, new String[] { "dan", "danpass" });
		

	}

}
