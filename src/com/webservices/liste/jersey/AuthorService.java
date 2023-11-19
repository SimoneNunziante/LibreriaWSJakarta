package com.webservices.liste.jersey;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import db.DB;

import java.sql.*;

@Path("/AuthorService")

public class AuthorService {
	@GET
	@Path("/authors")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Author> getTrackInJSON() {
		
		List<Author> listAutori = new ArrayList<>();
		
		try{
			Statement st1 = db.DB.getStmt(); 
			ResultSet rsAt =st1.executeQuery("SELECT * FROM autore");
			
			while(rsAt.next()) {
				
				int id = rsAt.getInt("ID_AUTORE");
				String nome = rsAt.getString("nome_autore");
                String surname = rsAt.getString("cognome_autore");

                Author autore = new Author();
                autore.setId(id);
                autore.setName(nome);
                autore.setSurname(surname);

                listAutori.add(autore);
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("ERRORE CLASS FORNAME");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listAutori;
		
	}
	
}
