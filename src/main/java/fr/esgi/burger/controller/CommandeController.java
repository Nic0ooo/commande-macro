package fr.esgi.burger.controller;

import fr.esgi.burger.business.Commandes;
import fr.esgi.burger.service.CommandeService;
import fr.esgi.burger.service.impl.CommandeServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;

public class CommandeController {

    private final CommandeService commandeService = new CommandeServiceImpl();

    @FXML
    private RadioButton radioConsoSurPlace;

    @FXML
    private RadioButton radioConsoEmporte;

    @FXML
    private ComboBox<String> burgerCombo;

    @FXML
    private ComboBox<String> accompagnementCombo;

    @FXML
    private ComboBox<String> boissonCombo;

    @FXML
    private CheckBox ketchupCheck;

    @FXML
    private CheckBox mayonnaiseCheck;

    @FXML
    private CheckBox samouraiCheck;

    @FXML
    private Button commanderBtn;

    @FXML
    private TextArea remarques;

    @FXML
    private ToggleGroup lieuConsommation;

    @FXML
    public void initialize() {
        // Initialiser les ComboBox avec des valeurs par défaut
        burgerCombo.getItems().addAll("CLELIA Burger", "Cheeseburger", "Double Cheese", "Veggie Burger");
        accompagnementCombo.getItems().addAll("Frites", "Salade", "Onion Rings", "Coleslaw");
        boissonCombo.getItems().addAll("Badoit", "Coca-Cola", "Ice Tea", "Fanta");
    }

    @FXML
    private void commander(ActionEvent event) {
        boolean surPlace = radioConsoSurPlace.isSelected();
        String burger = burgerCombo.getValue();
        String accompagnement = accompagnementCombo.getValue();
        String boisson = boissonCombo.getValue();

        // Ajoutez les détails de la commande
        if (burger == null || accompagnement == null || boisson == null) {
            System.out.println("Veuillez sélectionner un burger, un accompagnement et une boisson.");
            return;
        }

        commandeService.ajouterCommande(surPlace, burger, accompagnement, boisson);

        // Afficher confirmation
        System.out.println("Commande ajoutée pour " + (surPlace ? "sur place" : "à emporter") +
                " : " + burger + ", " + accompagnement + ", " + boisson);

        if (ketchupCheck.isSelected()) {
            System.out.println("Avec ketchup");
        }
        if (mayonnaiseCheck.isSelected()) {
            System.out.println("Avec mayonnaise");
        }
        if (samouraiCheck.isSelected()) {
            System.out.println("Avec sauce samouraï");
        }

        // Nettoyer les champs
        clearFields();
    }

    private void clearFields() {
        burgerCombo.getSelectionModel().clearSelection();
        accompagnementCombo.getSelectionModel().clearSelection();
        boissonCombo.getSelectionModel().clearSelection();
        ketchupCheck.setSelected(false);
        mayonnaiseCheck.setSelected(false);
        samouraiCheck.setSelected(false);
        remarques.clear();
    }
}