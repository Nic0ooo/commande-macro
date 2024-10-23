package fr.esgi.burger.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.esgi.burger.business.Accompagnement;
import fr.esgi.burger.business.Boisson;
import fr.esgi.burger.business.Burger;
import fr.esgi.burger.business.Commande;
import fr.esgi.burger.service.AccompagnementService;
import fr.esgi.burger.service.BoissonService;
import fr.esgi.burger.service.BurgerService;
import fr.esgi.burger.service.CommandeService;

public class CommandeServiceImpl implements CommandeService {

	private static List<Commande> commandes = new ArrayList<>();
	// Un service peut faire appel à d'autres services
	private BurgerService burgerService;
	private AccompagnementService accompagnementService;
	private BoissonService boissonService;

	// Un constructeur avec en paramètre
	// les dépendances du service
	// Ce faisant CommandeService reçoit une instance
	// de chaque service dont il a besoin
	public CommandeServiceImpl(BurgerService burgerService, AccompagnementService accompagnementService, BoissonService boissonService) {
		this.burgerService = burgerService;
		this.accompagnementService = accompagnementService;
		this.boissonService = boissonService;
	}

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
				.dateHeureCreation(LocalDateTime.now())
				.estSurPlace(estSurPlace)
				.burger(burgerService.recupererBurger(nomBurger))
				.boisson(boissonService.recuperBoisson(nomBoisson))
				.accompagnement(accompagnementService.recupererAccompagnement(nomAccompagnement))
				.remarques(remarques)
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