package Controller;

import java.sql.SQLException;
import java.util.Scanner;

import Model.Conexion;
import Model.Modelo;
import View.Vista;

public class Controlador {
	private Modelo model;
	private Vista view;

	Controlador(Modelo model, Vista view) {
		this.model = model;
		this.view = view;
	}

	public static void iniciarVista() {
		try {
			if (Conexion.getConnection() != null) {
				Vista.mostrarMensaje("Conexión a la base de datos correctamente.");

				System.out.println();

				int mostrarMenu;

				do {
					mostrarMenu = Vista.mostrarMenu();
					switch (mostrarMenu) {
					case 1:
						if (Modelo.inicializacionTabla()) {
							Vista.mostrarMensaje("\nInicilización de tablas correcta.");
							break;
						} else {
							Vista.mostrarMensaje("\nError al inicializar las tablas.");
						}
						break;
					case 2:
						if (Modelo.insertarPaqueteDatos()) {
							Vista.mostrarMensaje("\nPaquete de datos insertados correctamente.");
						} else {
							Vista.mostrarMensaje("\nError al insertar el paquete de datos. No hay tabla.");
						}
						break;
					case 3:
						if (Modelo.borrarTabla()) {
							Vista.mostrarMensaje("\nTabla borrada correctamente.");
						} else {
							Vista.mostrarMensaje("\nTabla no borrada. Ya está borrada.");
						}
						break;
					case 41:
						String introducirPieza = Vista.introducirPieza();

						if (Modelo.añadirRegistro(introducirPieza)) {
							Vista.mostrarMensaje("\nRegistro añadido correctamente.");
						} else {
							Vista.mostrarMensaje("\nError al añadir el registro. No hay tabla.");
						}
						break;
					case 42:
						String buscarPieza = Vista.buscarPieza();

						if (Modelo.consultarIDNombre(buscarPieza)) {
							Vista.mostrarMensaje("\nConsulta realizada correctamente");
						} else {
							Vista.mostrarMensaje("\nError al consultar los datos. No hay tabla.");
						}
						break;
					case 43:
						if (Modelo.listarTabla()) {
							Vista.mostrarMensaje("\nTabla listada correctamente.");
						} else {
							Vista.mostrarMensaje("\nError al listar la tabla. No hay tabla.");
						}
						break;
					case 44:
						String actualizarPieza = Vista.actualizarPieza();

						if (Modelo.actualizarRegistro(actualizarPieza)) {
							Vista.mostrarMensaje("\nRegistro actualizado correctamente");
						} else {
							Vista.mostrarMensaje("\nError al actualizar el registro. No hay tabla.");
						}
						break;
					case 45:
						int eliminarPieza = Vista.eliminarPieza();

						if (Modelo.eliminarRegistro(eliminarPieza)) {
							Vista.mostrarMensaje("\nRegistro eliminado correctamente");
						} else {
							Vista.mostrarMensaje("\nError al eliminar el registro. No hay tabla.");
						}
						break;
					case 5:
						Vista.mostrarMensaje("\nConexion cerrada correctamente");
						Conexion.getConnection().close();
						break;
					default:
						Vista.mostrarMensaje("Algo ha salido mal...");
					}
				} while (mostrarMenu != 5);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
