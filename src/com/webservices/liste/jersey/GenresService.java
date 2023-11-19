package com.webservices.liste.jersey;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import db.DB;

import java.sql.*;

@Path("/GenresService")

public class GenresService {
	@GET
	@Path("/genres")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Genres> getTrackInJSON() {
		
		List<Genres> listGeneri = new ArrayList<>();
		
		try{
			Statement st1 = db.DB.getStmt(); 
			ResultSet rsAt =st1.executeQuery("SELECT * FROM categoria");
			
			while(rsAt.next()) {
				
				int id = rsAt.getInt("ID_GENERE");
				String nome = rsAt.getString("Nome_Genere");

				Genres genres = new Genres();
                genres.setId(id);
                genres.setName(nome);

                listGeneri.add(genres);
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("ERRORE CLASS FORNAME");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listGeneri;
		
	}
	
}
