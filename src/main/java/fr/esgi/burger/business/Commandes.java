package fr.esgi.burger.business;

import lombok.Data;

import java.util.Objects;

@Data
public class Commandes {
    private Burger burger;
    private Accompagnement accompagnement;
    private Boisson boisson;

    public Commandes(Burger burger, Accompagnement accompagnement, Boisson boisson) {
        this.burger = burger;
        this.accompagnement = accompagnement;
        this.boisson = boisson;
    }

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public Accompagnement getAccompagnement() {
        return accompagnement;
    }

    public void setAccompagnement(Accompagnement accompagnement) {
        this.accompagnement = accompagnement;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public void setBoisson(Boisson boisson) {
        this.boisson = boisson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commandes commandes = (Commandes) o;
        return Objects.equals(burger, commandes.burger) && Objects.equals(accompagnement, commandes.accompagnement) && Objects.equals(boisson, commandes.boisson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(burger, accompagnement, boisson);
    }

    @Override
    public String toString() {
        return "Commandes{" +
                "burger=" + burger +
                ", accompagnement=" + accompagnement +
                ", boisson=" + boisson +
                '}';
    }
}
