package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Livre;
import com.example.demo.service.LivreService;

//NABIL MITA - 4IIR G3 CENTRE
@RestController // Ceci est un controller REST 
public class LivreController{
	@Autowired
	LivreService livreServ; // Instancier LivreService
	
	@GetMapping("/emsi_api/livres") // GET /emsi_api/livres 
	public List<Livre> getLivres(){
		return livreServ.getLivres();
	}
	
	@GetMapping("/emsi_api/livres/{id}") // GET /emsi_api/livres/id
	public Livre getLivre(@PathVariable int id){ // On récupère l'id passé par l'URI
		return livreServ.getLivre(id);
	}
	
	@PutMapping("/emsi_api/livres/edit/id={id}&titre={titre}") // PUT /emsi_api/livres/edit/id=1&titre=test
	public Livre updateLivre(@PathVariable int id, @PathVariable String titre) {
		return livreServ.updateLivre(id, titre);
    }

	@DeleteMapping("/emsi_api/livres/delete/{id}") // DELETE /emsi_api/livres/delete/id
	public void deleteLivre(@PathVariable int id) {
	   livreServ.deleteLivre(id);
    }

}
