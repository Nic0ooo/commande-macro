package fr.esgi.burger.business;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Accompagnement {

    private Long id;

    private String nom;

    private static Long compteur = 0L;

    public Accompagnement() {
        id = ++compteur;
    }

}
