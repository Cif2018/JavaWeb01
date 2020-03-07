package com.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadDataFromDB {

	public ArrayList<String[]> read(String dbPath, String dbName, String theTable, String[] theTableColumns)
			throws ClassNotFoundException {
		ArrayList<String[]> output = new ArrayList<String[]>();

		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		ResultSet rs = null;

		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath + dbName);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			rs = statement.executeQuery("select * from " + theTable + ";");

			while (rs.next()) {

				String[] temp = new String[2];
				temp[0] = rs.getString("user");
				temp[1] = rs.getString("password");

				output.add(temp);
			}

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

		return output;

	}

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String[] theTableColumns = new String[2];
		theTableColumns[0] = "user";
		theTableColumns[1] = "password";

		ReadDataFromDB rdfdb = new ReadDataFromDB();
		ArrayList<String[]> data = rdfdb.read(
				Login.pathLocation, "usersDB",
				"usersAndPasswords", theTableColumns);
		for (String[] s : data) {
			System.out.print(s[0] + " ");
			System.out.println(s[1]);
		}

	}

}
