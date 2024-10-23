package fr.esgi.burger.business;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
public class Commande {

	private Long id;
	private LocalDateTime dateHeureCreation;
	private boolean estSurPlace;
	private Burger burger;
	private Accompagnement accompagnement;
	private Boisson boisson;
	private String remarques;
	private List<String> sauces;
	private static Long compteur = 0L;

	// Default constructor
	// constructeur par défaut
	public Commande() {
		id = ++compteur;
		dateHeureCreation = LocalDateTime.now();
		sauces = new ArrayList<>();
	}

}