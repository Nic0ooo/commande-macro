package fr.esgi.burger.business;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Getter
public class Burger {

    private Long id;

    private String nom;

    private static Long compteur;


}
