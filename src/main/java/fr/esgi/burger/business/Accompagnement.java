package fr.esgi.burger.business;

import lombok.Data;

import java.util.Objects;

@Data
public class Accompagnement {

    private Long id;
    private String nom;
    private static Long compteur = 0L;

    // Constructeur par défaut
    public Accompagnement() {
        this.id = ++compteur;
    }

    // Constructeur qui accepte le nom
    public Accompagnement(String nom) {
        this.id = ++compteur;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static Long getCompteur() {
        return compteur;
    }

    public static void setCompteur(Long compteur) {
        Accompagnement.compteur = compteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accompagnement that = (Accompagnement) o;
        return Objects.equals(id, that.id) && Objects.equals(nom, that.nom);
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