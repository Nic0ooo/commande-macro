package fr.esgi.burger.service;

import fr.esgi.burger.business.Burger;

import java.util.List;

public interface BurgerService {

    List<Burger> ajouterBurgers();

    Burger ajouterBurger(Burger burger);

    List<Burger> recupererBurgers();

    /**
     * Cette méthode renvoie le burger dont l'id
     * est donné en paramètre
     *
     * @param id du burger recherché
     * @return l'objet Burger s'il est trouvé sinon null
     */
    Burger recupererBurger(Long id);

    /**
     * Cette méthode renvoie le burger dont le nom
     * est donné en paramètre
     *
     * @param nom du burger recherché
     * @return l'objet Burger s'il est trouvé sinon null
     */
    Burger recupererBurger(String nom);

    List<String> recupererNomBurgers();

    // YAGNI : You Arent' Gonna Need It
    // Pas besoin de déclarer la méthode de suppression
    // si elle ne va servir à personne
}