package fr.esgi.burger.service.impl;

import fr.esgi.burger.business.Accompagnement;
import fr.esgi.burger.business.Burger;
import fr.esgi.burger.service.AccompagnementService;

import java.util.ArrayList;
import java.util.List;

public class AccompagnementServiceImpl implements AccompagnementService {

    private static List<Accompagnement> accompagnements = new ArrayList<>();

    // Constructeur par défaut
    public AccompagnementServiceImpl() {
        ajouterAccompagnements();
    }

    @Override
    public List<Accompagnement> ajouterAccompagnements() {
        if (accompagnements.isEmpty()) {
            ajouterAccompagnement(new Accompagnement("Frites"));
            ajouterAccompagnement(new Accompagnement("Salade"));
            ajouterAccompagnement(new Accompagnement("Onion Rings"));
        }
        return accompagnements;
    }

    @Override
    public Accompagnement ajouterAccompagnement(Accompagnement accompagnement) {
        accompagnements.add(accompagnement);
        return accompagnement;
    }

    @Override
    public List<Accompagnement> recupererAccompagnements() {
        return accompagnements;
    }

    @Override
    public Accompagnement recupererAccompagnement(Long id) {
        return accompagnements.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Accompagnement recupererAccompagnement(String nom) {
        return accompagnements.stream().filter(a -> a.getNom().equals(nom)).findFirst().orElse(null);
    }

    @Override
    public List<String> recupererNomAccompagnements() {
        List<String> nomAccompagnements = new ArrayList<>();
        for (Accompagnement accompagnement : accompagnements) {
            nomAccompagnements.add(accompagnement.getNom());
        }
        return nomAccompagnements;
    }
}
