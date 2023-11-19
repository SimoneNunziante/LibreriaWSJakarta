package com.webservices.liste.jersey;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import db.DB;

import java.sql.*;

@Path("/ScaffaleService")

public class ScaffaleService {
	@GET
	@Path("/scaffale")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Scaffale> getTrackInJSON() {
		
		List<Scaffale> listScaffali = new ArrayList<>();
		
		try{
			Statement st1 = db.DB.getStmt(); 
			ResultSet rsAt =st1.executeQuery("SELECT * FROM scaffale");
			
			while(rsAt.next()) {
				
				int id = rsAt.getInt("ID_SCAFFALE");
				String nome = rsAt.getString("Nome_Scaffale");
				int capmax = rsAt.getInt("Capienza_Massima");
				int libreria = rsAt.getInt("p_Libreria");

				Scaffale scaffale = new Scaffale();
                scaffale.setId(id);
                scaffale.setName(nome);

                listScaffali.add(scaffale);
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("ERRORE CLASS FORNAME");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listScaffali;
		
	}
	
}
