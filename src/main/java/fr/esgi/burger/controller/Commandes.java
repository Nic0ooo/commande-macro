package fr.esgi.burger.controller;

public class Commandes {
    private String burger;
    private String accompagnement;
    private String boisson;

    public Commandes(String burger, String accompagnement, String boisson) {
        this.burger = burger;
        this.accompagnement = accompagnement;
        this.boisson = boisson;
    }
}
