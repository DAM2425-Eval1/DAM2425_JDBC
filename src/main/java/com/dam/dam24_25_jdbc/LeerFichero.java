package com.dam.dam24_25_jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerFichero {

	private static String rutaDriver = null;
	private static String rutaBBDD = null;
	private static String usuario = null;
	private static String password = null;

	public static Datos leerFicheroProp(String rutaFicheroProp, String gestor) throws IOException, ParserConfigurationException, SAXException{
		
			Path origen = Paths.get(rutaFicheroProp);
			BufferedReader br = Files.newBufferedReader(origen);

			Stream<String> lineas = br.lines();

			lineas.forEach(l -> { 
				String[] lineaProperties = l.split("=");
				if (lineaProperties[0].equals("driver" + gestor))
					rutaDriver = lineaProperties[1];
				else if (lineaProperties[0].equals("ruta" + gestor))
					rutaBBDD = lineaProperties[1];
				else if (lineaProperties[0].equals("usuario" + gestor))
					usuario = lineaProperties[1];
				else if (lineaProperties[0].equals("password" + gestor))
					password = lineaProperties[1];
			});
			
			/* 
			 * Empleando la clase Properties:
			 * 
			 * Properties valores = new Properties();
			 * valores.load(new FileReader("D:\\PRUEBAS\\conexion.properties"));
			 * 
			 * rutaDriver = valores.getProperty("driver" + gestor);
			 * rutaBBDD = valores.getProperty("ruta" + gestor);
			 * usuario = valores.getProperty("usuario" + gestor);
			 * password = valores.getProperty("password" + gestor);
			 * 
			 */

			return new Datos(rutaDriver, rutaBBDD, usuario, password);

	}

}
