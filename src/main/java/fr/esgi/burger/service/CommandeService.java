package fr.esgi.burger.service;

/**
 * L'interface peut etre vue comme l'ardoise du restaurant
 */

import java.util.List;

import fr.esgi.burger.business.Commande;

public interface CommandeService {

	// C
	Commande ajouterCommande(Commande commande);
	Commande ajouterCommande(boolean estSurPlace, String nomBurger, String nomAccompagnement, String nomBoisson, String remarques);

	// R
	List<Commande> recupererCommandes();
	
	Commande recupererCommande(Long id);

	// U
	Commande mettreAJourCommande(Commande commande);

	// D
	boolean supprimerCommande(Long id);

}