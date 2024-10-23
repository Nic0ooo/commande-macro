package fr.esgi.burger.service;

import fr.esgi.burger.business.Accompagnement;
import fr.esgi.burger.business.Burger;

import java.util.List;

public interface AccompagnementService {

    List<Accompagnement> ajouterAccompagnements();

    Accompagnement ajouterAccompagnement(Accompagnement accompagnement);

    List<Accompagnement> recupererAccompagnements();

    Accompagnement recupererAccompagnement(Long id);

    Accompagnement recupererAccompagnement(String nom);

    List<String> recupererNomAccompagnements();
}
