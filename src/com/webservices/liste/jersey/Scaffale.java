package com.webservices.liste.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Scaffale {

	private int id;
	private String name;
	private int capmax;
	private int libreria;
	
	public Scaffale() {
	  
	}

	public Scaffale(int id, String name, int capmax, int libreria) {
	    this.id = id;
	    this.name = name;
	    this.capmax = capmax;
	    this.libreria = libreria;
	}

	public int getId() {
	    return id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}
	
	public int getCapMax() {
	    return capmax;
	}
	
	public void setCapMax(int capmax) {
	    this.id = capmax;
	}
	
	public int getLibreria() {
	    return libreria;
	}
	
	public void setLibreria(int libreria) {
	    this.id = libreria;
	}
	
}