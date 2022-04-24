package com.example.demo;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;

//NABIL MITA - 4IIR G3 CENTRE
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	LivreRepo livreRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		final List<String> titres = List.of("D","A","C","B","X","E"); // Liste statique des titres
		if(livreRepo.count() == 0) {
			for(int i = 1; i < 6; i++) {
				livreRepo.save(new Livre(null, "Livre " + titres.get(i-1), "Maison " + i*4, new Date(), "BOT " + i, i*5, i*22, null, i%2==0));
			}
		}
		System.out.println("\n******** Rechercher le livre 3 ********");
		Livre livre3 = livreRepo.findById(3);
		System.out.println(livre3.toString());
		
	    System.out.println("\n******** Affichage des livres ********");
		List<Livre> livres = livreRepo.findAllByOrderByTitreAsc();
		livres.forEach(l -> { System.out.println(l.toString());} );
		
		System.out.println("\n******** Mise à jour du titre: Livre C -> Livre 99 ********");
		livre3.setNpages(340);
		livre3.setDisponible(true);
		livre3.setTitre("Livre 99");
		livreRepo.save(livre3);
		
		System.out.println("\n******** Affichage du livre 3 (C) modifié: ********");
		livre3 = livreRepo.findById(3);
		System.out.println(livre3.toString());
		
		System.out.println("\n******** Affichage des livres ********");
		livres = livreRepo.findAllByOrderByTitreAsc();
		livres.forEach(l -> { System.out.println(l.toString());} );
		System.out.println("Livres count: " + livreRepo.count());
		
		System.out.println("\n******** Suppression du livre 3 ********");
		livreRepo.deleteById(3);
		livres = livreRepo.findAllByOrderByTitreAsc();
		livres.forEach(l -> { System.out.println(l.toString());} );
		System.out.println("Livres count: " + livreRepo.count());
	}

}
