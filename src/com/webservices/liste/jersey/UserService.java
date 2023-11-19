package com.webservices.liste.jersey;

import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import db.DB;

import java.sql.*;

@Path("/UserService")

public class UserService {
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<User> getTrackInJSON() {
		
		List<User> listUsers = new ArrayList<>();
		
		try{
			Statement st1 = db.DB.getStmt(); 
			ResultSet rsAt =st1.executeQuery("SELECT * FROM user");
			
			while(rsAt.next()) {
				
				int id = rsAt.getInt("ID_USER");
				String nome = rsAt.getString("Nome");
				String cognome = rsAt.getString("Cognome");
				String email = rsAt.getString("Email");
				String password = rsAt.getString("Password");

				User users = new User();
                users.setId(id);
                users.setName(nome);
                users.setCognome(cognome);
                users.setEmail(email);
                users.setPassword(password);

                listUsers.add(users);
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("ERRORE CLASS FORNAME");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listUsers;
		
	}
	
}
