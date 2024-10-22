package fr.esgi.burger.business;

import java.util.Objects;

public class Accompagnement {
    private long id;
    private String nom;
    private static long compteur;

    public Accompagnement(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static long getCompteur() {
        return compteur;
    }

    public static void setCompteur(long compteur) {
        Accompagnement.compteur = compteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accompagnement that = (Accompagnement) o;
        return id == that.id && Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return "Accompagnement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
