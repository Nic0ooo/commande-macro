package fr.esgi.burger.service.impl;

import fr.esgi.burger.business.Commandes;
import fr.esgi.burger.business.Burger;
import fr.esgi.burger.business.Accompagnement;
import fr.esgi.burger.business.Boisson;
import fr.esgi.burger.service.CommandeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandeServiceImpl implements CommandeService {

    // Liste pour stocker les commandes
    private final List<Commandes> commandesList = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public void ajouterCommande(Commandes commandes) {
        commandesList.add(commandes);
        System.out.println("Commande ajoutée : " + commandes);
    }

    @Override
    public void recupererCommandes() {
        System.out.println("Liste de toutes les commandes :");
        commandesList.forEach(System.out::println);
    }

    @Override
    public void mettreAJourCommande(Commandes commande) {
        Optional<Commandes> existingCommande = commandesList.stream()
                .filter(c -> c.equals(commande))
                .findFirst();
        if (existingCommande.isPresent()) {
            commandesList.remove(existingCommande.get());
            commandesList.add(commande);
            System.out.println("Commande mise à jour : " + commande);
        } else {
            System.out.println("Commande non trouvée.");
        }
    }

    @Override
    public void supprimerCommande(Long id) {
        if (id < commandesList.size()) {
            Commandes commandeToRemove = commandesList.get(id.intValue());
            commandesList.remove(commandeToRemove);
            System.out.println("Commande supprimée : " + commandeToRemove);
        } else {
            System.out.println("Commande avec ID " + id + " non trouvée.");
        }
    }

    @Override
    public void ajouterCommande(boolean surPlace, String burger, String accompagnement, String boisson) {
        // Créer les objets avec les bons constructeurs
        Burger burgerObj = new Burger(burger); // Nom du burger fourni
        Accompagnement accompagnementObj = new Accompagnement(accompagnement); // Nom de l'accompagnement fourni
        Boisson boissonObj = new Boisson(0L, boisson); // ID par défaut de 0L et nom fourni

        // Créer et ajouter la nouvelle commande
        Commandes nouvelleCommande = new Commandes(burgerObj, accompagnementObj, boissonObj);        nouvelleCommande.setBurger(burgerObj);
        nouvelleCommande.setAccompagnement(accompagnementObj);
        nouvelleCommande.setBoisson(boissonObj);

        this.ajouterCommande(nouvelleCommande);
    }

    @Override
    public void recupererCommande(Long id) {
        if (id < commandesList.size()) {
            Commandes commande = commandesList.get(id.intValue());
            System.out.println("Commande trouvée : " + commande);
        } else {
            System.out.println("Commande avec ID " + id + " non trouvée.");
        }
    }
}