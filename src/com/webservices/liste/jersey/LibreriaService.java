package com.webservices.liste.jersey;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import db.DB;

import java.sql.*;

@Path("/LibreriaService")

public class LibreriaService {
	@GET
	@Path("/librerie")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Libreria> getTrackInJSON() {
		
		List<Libreria> listLibreria = new ArrayList<>();
		
		try{
			Statement st1 = db.DB.getStmt(); 
			ResultSet rsAt =st1.executeQuery("SELECT * FROM libreria_componibile");
			
			while(rsAt.next()) {
				
				int id = rsAt.getInt("ID_LIBRERIA");
				String nome = rsAt.getString("Nome_Libreria");
				int utente = rsAt.getInt("p_User");

				Libreria libreria = new Libreria();
                libreria.setId(id);
                libreria.setName(nome);
                libreria.setUtente(utente);

                listLibreria.add(libreria);
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("ERRORE CLASS FORNAME");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listLibreria;
		
	}
	
}
