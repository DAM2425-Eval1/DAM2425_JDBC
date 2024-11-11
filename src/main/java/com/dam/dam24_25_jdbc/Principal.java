package com.dam.dam24_25_jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Principal {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException, ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;
		
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();

		asignaturas = leerXML("D:\\PRUEBAS\\asignaturas.xml");
		Properties props = new Properties();
		props.load(new FileInputStream("D:\\PRUEBAS\\conexiones.properties"));
		
		while (true) {
			mostrarMenu();
			opcion = leerTeclado(scanner);
			switch (opcion) {
				case 1: {
					//Conexion.insertarMySQL(asignaturas);
//					Conexion.insertarBBDD(asignaturas, "com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/asignaturas", 
//							              "root", "1234.Abcd");
					Conexion.insertarBBDD(asignaturas, props.getProperty("driverMySQL"), props.getProperty("rutaMySQL"), 
										 props.getProperty("usuarioMySQL"), props.getProperty("passwordMySQL"));
					break;
				}
				case 2: {
					//Conexion.insertarPostGres(asignaturas);
//					Conexion.insertarBBDD(asignaturas, "org.postgresql.Driver", "jdbc:postgres://localhost/asignaturas", 
//				              "postgres", "1234.Abcd");
					Conexion.insertarBBDD(asignaturas, props.getProperty("driverPostgres"), props.getProperty("rutaPostgres"), 
							 props.getProperty("usuarioPostgres"), props.getProperty("passwordPostgres"));
					break;
				}
				case 0:
					System.exit(0);
				default:
					System.out.println("Valor no válido: " + opcion);
			}
		}

	}

	private static ArrayList<Asignatura> leerXML(String rutaXML) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(rutaXML);
		
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		
		NodeList nombres = doc.getElementsByTagName("nombre");
		NodeList horas = doc.getElementsByTagName("horas");
		NodeList profesores = doc.getElementsByTagName("profesor");
		
		for(int i=0; i<nombres.getLength(); i++) {
			asignaturas.add(new Asignatura(nombres.item(i).getTextContent(), 
										   Integer.parseInt(horas.item(i).getTextContent()), 
										   profesores.item(i).getTextContent()));
		}
		
		return asignaturas;
	}

	private static int leerTeclado(Scanner scanner) {

		int opcion;
		try {
			opcion = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			opcion = -1;
		}
		return opcion;

	}

	private static void mostrarMenu() {

		System.out.println("1. Insertar en MySQL");
		System.out.println("2. Insertar en PostGres");
		System.out.println("0. Salir");

	}
	
	


}
