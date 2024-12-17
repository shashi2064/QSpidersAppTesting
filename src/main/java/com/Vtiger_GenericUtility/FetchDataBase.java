package com.Vtiger_GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataBase {

	Connection c;
	Statement s;
	ResultSet result;
	int data;

	public Connection connectiontodb() {

		Driver driver;

		try {

			driver = new Driver();

			DriverManager.registerDriver(driver);

			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/shashi", "root", "Shashi@6420");

		} catch (Exception e) {

			System.out.println("Invalid data credentials");
		}

		return c;

	}

	public void closeconwithDatabase() {
		try {
			c.close();
		} catch (SQLException e) {

			System.out.println("Database connection opened");
		}
	}

	public ResultSet executeselectQuery(String query) {
		try {
			s = c.createStatement();
		} catch (SQLException e) {
			System.out.println("Not created statement");
		}

		try {
			result = s.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int executeNonselectQuery(String query) {
		try {
			s = c.createStatement();
		} catch (SQLException e) {
			System.out.println("Not created statement");
		}

		try {
			data = s.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	public Connection getDBConnection() {
		Driver driver;

		try {
			driver = new Driver();

			DriverManager.registerDriver(driver);

			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/shashi", "root", "Shashi@6420");
		} catch (SQLException e) {
			System.out.println("Invalid data credentials");
		}
		return c;

	}

}
