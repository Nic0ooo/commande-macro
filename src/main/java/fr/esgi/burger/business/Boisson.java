package fr.esgi.burger.business;

import lombok.*;

@Data
@ToString(of = {"id", "nom"})
public class Boisson {

    private Long id;

    @NonNull
    private String nom;

    private static Long compteur = 0L;

    public Boisson(String nom) {
        id = ++compteur;
        this.nom = nom;
    }
}
