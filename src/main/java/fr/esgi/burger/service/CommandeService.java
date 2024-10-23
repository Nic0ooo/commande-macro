package fr.esgi.burger.service;

import fr.esgi.burger.business.Commandes;

public interface CommandeService {
    void ajouterCommande(Commandes commandes);
    void recupererCommandes();
    void mettreAJourCommande(Commandes commandes);
    void supprimerCommande(Long id);
    void ajouterCommande(boolean surPlace, String burger, String accompagnement, String boisson);
    void recupererCommande(Long id);
}
