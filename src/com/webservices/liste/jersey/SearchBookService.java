package com.webservices.liste.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Path("/SearchBookService")

public class SearchBookService {
	@GET
	@Path("/searchbooks")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Book> getTrackInJSON() {
		
		List<Book> listLibri = new ArrayList<>();
		
		String param = "cavaliere";
		
		try{
			Statement st1 = db.DB.getStmt(); 
			ResultSet rsAt =st1.executeQuery("SELECT * FROM libro WHERE Titolo_Libro LIKE '%" + param + "%'");
			
			while(rsAt.next()) {
				
				int id = rsAt.getInt("ID_Libro");
				String titolo = rsAt.getString("Titolo_Libro");
                int anno = rsAt.getInt("Anno_pubblicazione");
                int scaffale = rsAt.getInt("p_Scaffale");
                int autore = rsAt.getInt("p_Autore");
                int categoria = rsAt.getInt("p_Categoria");

                Book libri = new Book();
                libri.setId(id);
                libri.setTitolo(titolo);
                libri.setAnno(anno);
                libri.setScaffale(scaffale);
                libri.setAutore(autore);
                libri.setCategoria(categoria);

                listLibri.add(libri);
			}
			
		} catch(ClassNotFoundException e){
			System.out.println("ERRORE CLASS FORNAME");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listLibri;
		
	}
	
}
