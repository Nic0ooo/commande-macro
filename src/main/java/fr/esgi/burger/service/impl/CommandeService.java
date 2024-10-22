package fr.esgi.burger.service.impl;

public interface CommandeService {
    void ajouterBurger(String burger);
    void ajouterAccompagnement(String accompagnement);
    void ajouterBoisson(String boisson);
    void ajouterConsoSurPlace();
    void ajouterConsoEmporte();
    void validerCommande();
    void annulerCommande();
    void afficherCommande();
    void afficherPrix();
    void afficherTicket();
}
