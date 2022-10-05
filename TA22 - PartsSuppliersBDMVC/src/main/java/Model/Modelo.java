package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.Controlador;
import View.Vista;

public class Modelo {

	class Piezas {
		public int codigo;
		public String nombre;

		public Piezas(String nombre) {
			super();
			this.nombre = nombre;
		}

		public Piezas(int codigo, String nombre) {
			super();
			this.codigo = codigo;
			this.nombre = nombre;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}

	// MÉTODOS
	public static boolean borrarTabla() {

		try {
			Conexion.getStatement().executeUpdate("DROP TABLE PIEZAS;");
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	public static boolean listarTabla() {

		try {
			ResultSet rs1 = Conexion.getStatement().executeQuery("SELECT * FROM PIEZAS;");
			System.out.println();
			while (rs1.next()) {
				System.out.println(rs1.getString(1) + " " + rs1.getString(2));
			}
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	public static boolean añadirRegistro(String valor1) {

		try {
			String add = "INSERT INTO PIEZAS (Codigo, Nombre) VALUES (" + valor1 + ");";
			Conexion.getStatement().executeUpdate(add);
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	public static boolean actualizarRegistro(String valor2) {

		try {
			String update = "UPDATE PIEZAS SET " + valor2 + ";";
			Conexion.getStatement().executeUpdate(update);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public static boolean eliminarRegistro(int valor3) {

		try {
			String delete = "DELETE FROM PIEZAS WHERE Codigo = " + valor3 + ";";
			Conexion.getStatement().executeUpdate(delete);
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	public static boolean consultarIDNombre(String condicion) {

		try {

			ResultSet rs2 = Conexion.getStatement().executeQuery("SELECT * FROM PIEZAS WHERE " + condicion + ";");
			System.out.println();
			while (rs2.next()) {
				System.out.println(rs2.getString(1) + " " + rs2.getString(2));
			}
		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	public static boolean inicializacionTabla() {

		try {

			borrarTabla();

			Conexion.getStatement().executeUpdate("CREATE TABLE PIEZAS (" + "Codigo INT NOT NULL, "
					+ "Nombre NVARCHAR(100), " + "PRIMARY KEY (Codigo))");

		} catch (SQLException e) {
			return false;
		}

		return true;
	}

	public static boolean insertarPaqueteDatos() {

		try {

			int codigo[] = { 7178, 4562, 2346, 1783, 2235, 8923, 9797, 1845, 8376, 5727 };
			String nombrePieza[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
			for (int i = 0; i < codigo.length; i++) {
				Conexion.getStatement().executeUpdate("INSERT INTO PIEZAS (Codigo, Nombre) VALUES (" + "'" + codigo[i]
						+ "','" + nombrePieza[i] + "' )");
			}

		} catch (SQLException e) {
			return false;
		}

		return true;
	}

}
