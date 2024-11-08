package com.dam.dam24_25_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conexion {
	/*
	public static void insertarMySQL(ArrayList<Asignatura> asignaturas) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/asignaturas", "root" , "1234.Abcd");
		
		PreparedStatement insercion = conexion.prepareStatement("INSERT INTO asignaturas(nombre, horas, profesor) VALUES(?, ?, ?)");
		
		for (Asignatura a: asignaturas) {
			insercion.setString(1, a.getNombre());
			insercion.setInt(2, a.getHoras());
			insercion.setString(3, a.getProfesor());
			
			insercion.executeUpdate();
		}
		
		
	}
	
	public static void insertarPostGres(ArrayList<Asignatura> asignaturas) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		
		Connection conexion = DriverManager.getConnection("jdbc:postgres://localhost/asignaturas", "postgres" , "1234.Abcd");
		
		PreparedStatement insercion = conexion.prepareStatement("INSERT INTO asignaturas(nombre, horas, profesor) VALUES(?, ?, ?)");
		
		for (Asignatura a: asignaturas) {
			insercion.setString(1, a.getNombre());
			insercion.setInt(2, a.getHoras());
			insercion.setString(3, a.getProfesor());
			
			insercion.executeUpdate();
		}
		
	}
	*/
	
public static void insertarBBDD(ArrayList<Asignatura> asignaturas, String driver, String ruta, String usuario, String password) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		
		Connection conexion = DriverManager.getConnection(ruta, usuario , password);
		
		PreparedStatement insercion = conexion.prepareStatement("INSERT INTO asignaturas(nombre, horas, profesor) VALUES(?, ?, ?)");
		
		for (Asignatura a: asignaturas) {
			insercion.setString(1, a.getNombre());
			insercion.setInt(2, a.getHoras());
			insercion.setString(3, a.getProfesor());
			
			insercion.executeUpdate();
		}
		
	}

}
