package com.example.demo.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Livre;

//NABIL MITA - 4IIR G3 CENTRE
public interface LivreRepo extends JpaRepository<Livre, Integer>{
	
	public Livre findById(int id);
	public Livre deleteById(int id);
	public List<Livre> findAllByOrderByTitreAsc();
	
}