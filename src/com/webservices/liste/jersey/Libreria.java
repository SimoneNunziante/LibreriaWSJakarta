package com.webservices.liste.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libreria {

	private int id;
	private String name;
	private int utente;
	
	public Libreria() {
	  
	}

	public Libreria(int id, String name, int capmax, int utente) {
	    this.id = id;
	    this.name = name;
	    this.utente = utente;
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
	
	public int getUtente() {
	    return utente;
	}
	
	public void setUtente(int utente) {
	    this.utente = utente;
	}
	
}