package fr.esgi.burger.controller;

import java.io.IOException;

import fr.esgi.burger.App;
import javafx.fxml.FXML;

public class CommandesController {

    @FXML
    private void afficherNouvelleCommande() throws IOException {
       App.setRoot("commande");
    }
}