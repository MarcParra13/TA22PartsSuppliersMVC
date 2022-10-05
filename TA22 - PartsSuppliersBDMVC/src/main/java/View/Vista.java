package View;

import java.sql.SQLException;
import java.util.Scanner;

import Model.Conexion;
import Model.Modelo;

public class Vista {
	static Scanner teclado = new Scanner(System.in);

	public static void mostrarMensaje(String mensaje) {
		System.out.print(mensaje);
	}

	public static String introducirPieza() {
		System.out.println("\nIntroduce el código (4 números)");
		String valorCodigo = teclado.nextLine();
		System.out.println("\nIntroduce el nombre (Max. 100 carácteres)");
		String valorNombrePieza = teclado.nextLine();

		return "\'" + valorCodigo + "\'" + ", " + "\'" + valorNombrePieza + "\'";
	}

	public static String buscarPieza() {
		String consultaIdNombre = "";

		System.out.println("\nQuieres consultar un código o un nombre? (Introduce el número)");
		System.out.println("1 - Código");
		System.out.println("2 - Nombre");
		int decisionConsulta = teclado.nextInt();

		switch (decisionConsulta) {
		case 1:
			System.out.println("\nPor que nombre quieres buscar para encontrar el código?");
			teclado.nextLine();
			String consultarNombre = teclado.nextLine();
			consultaIdNombre = "Nombre = " + "'" + consultarNombre + "'";
			break;
		case 2:
			System.out.println("\nPor que código quieres buscar para encontrar el nombre?");
			int consultarCodigo = teclado.nextInt();
			consultaIdNombre = "Codigo = " + consultarCodigo;
			break;
		}
		return consultaIdNombre;

	}

	public static String actualizarPieza() {
		String modificarColumna = "";
		System.out.println("\nQué columna quieres modificar? (Introduce el número)");
		System.out.println("1 - Codigo");
		System.out.println("2 - Nombre");
		int modificarColumna1 = teclado.nextInt();

		switch (modificarColumna1) {
		case 1:
			System.out.println("\nDe qué Nombre?");
			teclado.nextLine();
			String modificarCondicion1 = teclado.nextLine();

			System.out.println("\nValor que quieres introducir? (4 números)");
			int modificarValor1 = teclado.nextInt();

			modificarColumna = "Codigo = " + modificarValor1 + " WHERE Nombre = " + "'" + modificarCondicion1 + "'";
			break;
		case 2:
			System.out.println("\nDe qué Código? (4 números)");
			int modificarCondicion2 = teclado.nextInt();

			System.out.println("\nValor que quieres introducir? (Max. 100 carácteres)");
			teclado.nextLine();
			String modificarValor2 = teclado.nextLine();

			modificarColumna = "Nombre = " + "'" + modificarValor2 + "'" + " WHERE Codigo = " + modificarCondicion2;
			break;
		}

		return modificarColumna;
	}

	public static int eliminarPieza() {
		System.out.println("\nDe qué Código quieres eliminar la pieza?");
		int condicionEliminar = teclado.nextInt();

		return condicionEliminar;
	}

	public static int mostrarMenu() throws SQLException {
		Scanner teclado = new Scanner(System.in);
		int operacion = 0;

		System.out.println();
		System.out.println("\nQué operación quieres realizar? (Introduce el número)");
		System.out.println("1 - Inicializar tablas");
		System.out.println("2 - Insertar paquete de datos");
		System.out.println("3 - Borrar tabla");
		System.out.println("4 - CRUD");
		System.out.println("5 - Cerrar conexión a la BD");
		operacion = teclado.nextInt();

		switch (operacion) {
		case 1:
			System.out.println("\nEstás segur@ de que quieres borrar la tabla y crearla de nuevo? (Si / No)");
			String inicializarTabla = teclado.next();

			if (inicializarTabla.equalsIgnoreCase("Si")) {
				operacion = 1;
				break;
			} else {
				break;
			}
		case 2:
			operacion = 2;
			break;
		case 3:
			operacion = 3;
			break;
		case 4:
			System.out.println("\nQué acción en la tabla quieres realizar? (Introduce el número)");
			System.out.println("1 - Añadir registro");
			System.out.println("2 - Consultar ID/Nombre");
			System.out.println("3 - Listar registros");
			System.out.println("4 - Modificar registro");
			System.out.println("5 - Borrar registro");
			int accion = teclado.nextInt();

			switch (accion) {
			case 1:
				operacion = 41;
				break;
			case 2:
				operacion = 42;
				break;
			case 3:
				operacion = 43;
				break;
			case 4:
				operacion = 44;
				break;
			case 5:
				operacion = 45;
				break;
			}
			break;
		case 5:
			operacion = 5;
			break;
		}

		return operacion;
	}
}