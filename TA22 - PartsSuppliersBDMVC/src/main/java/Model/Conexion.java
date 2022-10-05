package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.Controlador;
import View.Vista;

public class Conexion {
	private static final String BD = "partssuppliers3";
	private static final String USER = "root";
	private static final String PASSWORD = "kirito1234";
	private static final String URL = "jdbc:mysql://localhost:3306/" + BD;

	private static Connection ctn = null;
	
	public static Connection getConnection() {
		try {
			if (ctn == null) {
				ctn = DriverManager.getConnection(URL, USER, PASSWORD);
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		
		return ctn;
	}
	
	public static Statement getStatement() throws SQLException {
		
		Statement st = ctn.createStatement();
		
		return st;
	}
}
