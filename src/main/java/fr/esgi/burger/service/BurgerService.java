package fr.esgi.burger.service;

import fr.esgi.burger.business.Burger;

import java.util.List;

public interface BurgerService {

    Burger ajouterBurger(Burger burger);

    List<Burger> recupererBurgers();

    Burger recupererBurger(Long id);

    Burger recupererBurger(String nom);

    // YAGNI : You Arent' Gonna Need It
    // Pas besoin de déclarer la méthode de suppression
    // si elle ne va servir à personne
}