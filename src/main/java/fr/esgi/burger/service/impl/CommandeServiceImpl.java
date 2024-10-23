package fr.esgi.burger.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.burger.business.Accompagnement;
import fr.esgi.burger.business.Boisson;
import fr.esgi.burger.business.Burger;
import fr.esgi.burger.business.Commande;
import fr.esgi.burger.service.BurgerService;
import fr.esgi.burger.service.CommandeService;

public class CommandeServiceImpl implements CommandeService {

	private static List<Commande> commandes = new ArrayList<>();
	private BurgerService burgerService;

	// On implémente une métode qui est déclarée dans l'interface
	@Override
	public Commande ajouterCommande(Commande commande) {
		commandes.add(commande);
		return commande;
	}

	@Override
	public Commande ajouterCommande(boolean estSurPlace, String nomBurger, String nomAccompagnement, String nomBoisson, String remarques) {
		//Commande commande = new Commande();
		Commande commande = Commande.builder()
				.burger(new Burger())
				.boisson(new Boisson())
				.accompagnement(new Accompagnement())
				.remarques("")
				.build();
		commandes.add(commande);
		return commande;
	}

	@Override
	public List<Commande> recupererCommandes() {
		return commandes;
	}

	@Override
	public Commande recupererCommande(Long id) {
		return commandes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Commande mettreAJourCommande(Commande commande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supprimerCommande(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}