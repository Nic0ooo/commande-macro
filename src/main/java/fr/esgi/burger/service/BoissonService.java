package fr.esgi.burger.service;

import fr.esgi.burger.business.Boisson;
import fr.esgi.burger.business.Burger;

import java.util.List;

public interface BoissonService {

    List<Boisson> ajouterBoissons();

    Boisson ajouterBoisson(Boisson boisson);

    Boisson recuperBoisson(String nom);

    List<String> recupererNomBoissons();
}
