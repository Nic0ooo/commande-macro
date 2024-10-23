package fr.esgi.burger.service.impl;

import fr.esgi.burger.business.Accompagnement;
import fr.esgi.burger.business.Boisson;
import fr.esgi.burger.business.Burger;
import fr.esgi.burger.service.BoissonService;

import java.util.ArrayList;
import java.util.List;

public class BoissonServiceImpl implements BoissonService {

    private static List<Boisson> boissons = new ArrayList<>();

    public BoissonServiceImpl() {
        ajouterBoissons();
    }

    @Override
    public List<Boisson> ajouterBoissons() {
        if (boissons.isEmpty()) {
            ajouterBoisson(new Boisson("Badoit"));
            ajouterBoisson(new Boisson("Coca-Cola"));
            ajouterBoisson(new Boisson("Pepsi Cola"));
            ajouterBoisson(new Boisson("Tropico"));
        }
        return boissons;
    }

    @Override
    public Boisson ajouterBoisson(Boisson boisson) {
        boissons.add(boisson);
        return boisson;
    }

    @Override
    public Boisson recuperBoisson(String nom) {
        return boissons.stream().filter(b -> b.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public List<String> recupererNomBoissons() {
        List<String> nomBoissons = new ArrayList<>();
        for (Boisson boisson : boissons) {
            nomBoissons.add(boisson.getNom());
        }
        return nomBoissons;
    }
}
