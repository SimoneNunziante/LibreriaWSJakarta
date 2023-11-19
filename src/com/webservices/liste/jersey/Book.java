package com.webservices.liste.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

	private int id;
	private String titolo;
	private int anno;
	private int scaffale;
	private int autore;
	private int categoria;
	
	public Book() {
	  
	}

	public Book(int id, String titolo, int anno, int scaffale, int autore, int categoria) {
	    this.id = id;
	    this.titolo = titolo;
	    this.anno = anno;
	    this.scaffale = scaffale;
	    this.autore = autore;
	    this.categoria = categoria;
	}

	public int getId() {
	    return id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}

	public String getTitolo() {
	    return titolo;
	}

	public void setTitolo(String titolo) {
	    this.titolo = titolo;
	}
	
	public int getAnno() {
	    return anno;
	}

	public void setAnno(int anno) {
	    this.anno = anno;
	}
	
	public Integer getScaffale() {
	    return scaffale;
	}

	public void setScaffale(int scaffale) {
	    this.scaffale = scaffale;
	}
	
	public Integer getAutore() {
	    return autore;
	}

	public void setAutore(int autore) {
	    this.autore = autore;
	}
	
	public Integer getCategoria() {
	    return categoria;
	}

	public void setCategoria(int categoria) {
	    this.categoria = categoria;
	}
}