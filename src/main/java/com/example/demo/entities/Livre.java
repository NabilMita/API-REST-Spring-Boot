package com.example.demo.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//NABIL MITA - 4IIR G3 CENTRE
@Entity @Table(name = "LIVRES") 
@Data @AllArgsConstructor @NoArgsConstructor // Getters, setters, constructeur de paramètres et par défaut sont générés automatiquement
public class Livre {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@Column(length = 50, nullable = false)
	private String titre;
	
	@Column(nullable = false, updatable = false)
	private String maison;
	
	@Temporal(TemporalType.DATE)
	private Date dsortie;
	
	@Column(nullable = false)
	private String auteur;
	
	@Column(nullable = false)
	private int npages;
	
	@Column(unique = true, nullable = false, updatable = false)
	private long isbn;
	
	@Temporal(TemporalType.TIMESTAMP) @CreationTimestamp
	private Date dconsultation;
	
	@Column(nullable = false)
	private Boolean disponible;

}
