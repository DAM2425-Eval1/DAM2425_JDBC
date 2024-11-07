package com.dam.dam24_25_jdbc;

public class Asignatura{
	
	private String nombre;
	private int horas;
	private String profesor;
	
	public Asignatura(String nombre, int horas, String profesor) {
		this.nombre = nombre;
		this.horas = horas;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	

}
