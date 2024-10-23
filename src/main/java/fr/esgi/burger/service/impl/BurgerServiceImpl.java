package fr.esgi.burger.service.impl;

import fr.esgi.burger.business.Burger;
import fr.esgi.burger.service.BurgerService;

import java.util.ArrayList;
import java.util.List;

public class BurgerServiceImpl implements BurgerService {

    private static List<Burger> burgers = new ArrayList<>();

    // Constructeur par défaut
    public BurgerServiceImpl() {
        ajouterBurgers();
    }

    @Override
    public List<Burger> ajouterBurgers() {
        if (burgers.isEmpty()) {
            ajouterBurger(new Burger("CLELIA Burger"));
            ajouterBurger(new Burger("Polenta Burger"));
            ajouterBurger(new Burger("Rice Burger"));
        }
        return burgers;
    }

    @Override
    public Burger ajouterBurger(Burger burger) {
        burgers.add(burger);
        return burger;
    }

    @Override
    public List<Burger> recupererBurgers() {
        return burgers;
    }

    @Override
    public Burger recupererBurger(Long id) {
        return burgers.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Burger recupererBurger(String nom) {
        return burgers.stream().filter(b -> b.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public List<String> recupererNomBurgers() {
        List<String> nomBurgers = new ArrayList<>();
        for (Burger burger : burgers) {
            nomBurgers.add(burger.getNom());
        }
        return nomBurgers;
    }
}
