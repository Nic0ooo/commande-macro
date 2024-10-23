package fr.esgi.burger.business;

import lombok.*;

@Data
@ToString(of = {"id", "nom"})
@NoArgsConstructor
@RequiredArgsConstructor
public class Boisson {

    private Long id;

    @NonNull
    private String nom;

    private static Long compteur;

}
