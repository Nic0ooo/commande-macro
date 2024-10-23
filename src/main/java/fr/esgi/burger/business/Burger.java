package fr.esgi.burger.business;

import lombok.*;

@Data
@Getter
public class Burger {

    private Long id;

    private String nom;

    private static Long compteur = 0L;

    public Burger(String nom) {
        id = ++compteur;
        this.nom = nom;
    }
}
