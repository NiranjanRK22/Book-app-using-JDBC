/*Author : Niranjan
version : 1.0
date: 10/11/2021*/

package com.bookapp.dao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ModelDAO {
	static Connection connection;

	public static Connection openConnection() {
		Properties properties = new Properties();
		
		try  {
			properties.load(new FileReader("jdbc.properties"));
			
		}
		catch (FileNotFoundException e1)  {
			e1.printStackTrace();
		}
		catch (IOException e1)  {
			e1.printStackTrace();
		}
		
		
		String url = properties.getProperty("driver");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		connection = null;
		
		try {
			//Class.forName(drivername);
			connection = DriverManager.getConnection(url, username, password);
		}
		catch ( SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
