package com.example.demo.service;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//NABIL MITA - 4IIR G3 CENTRE
@Service // Ceci est une classe Service
public class LivreService {
	
	@Autowired
	LivreRepo livreRepo; // Instancier LivreRepo
	
	public List<Livre> getLivres(){
		return livreRepo.findAllByOrderByTitreAsc(); 
	}
	
	public Livre getLivre(int id) {
		return livreRepo.findById(id);
	}
	
	public Livre updateLivre(int id, String titre) {
		Livre livre = (Livre) livreRepo.findById(id);
		 if(livre == null) {
			 return null;
		 }
		 livre.setTitre(titre);
		 livre.setDisponible(true);
		 return livreRepo.save(livre);
	}
	
	public void deleteLivre(int id) {
		 livreRepo.deleteById(id);
	}
}
