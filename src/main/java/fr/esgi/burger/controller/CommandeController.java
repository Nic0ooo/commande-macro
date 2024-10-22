package fr.esgi.burger.controller;

import fr.esgi.burger.service.impl.CommandeService;
import fr.esgi.burger.service.impl.CommandeServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {
    public CheckBox samouraiCheck;
    public CheckBox mayonnaiseCheck;
    public CheckBox ketchupCheck;
    private Long id;
    private boolean estSurPlace;
    private String burger;
    private String accompagnement;
    private String boisson;
    private double prix;
    private String remarquesTextArea;

    private final CommandeService commandeService = new CommandeServiceImpl();

    private ObservableList<String> burgers =
            FXCollections.observableArrayList("Big Mac","CBO","280","McFirst","McFish","McChicken","Royal Cheese");

    private ObservableList<String> accompagnements =
            FXCollections.observableArrayList("Frites","Coleslaw","Salade","Potatoes","Nuggets","Onion Rings");

    private ObservableList<String> boissons =
            FXCollections.observableArrayList("Coca Cola","Coca Cola Zero","Fanta","Badoit","Ice Tea");

    @FXML
    private RadioButton radioConsoSurPlace;

    @FXML
    private ToggleGroup lieuConsommation;

    @FXML
    private RadioButton radioConsoEmporte;

    @FXML
    private ListView<String> burgerListView;

    @FXML
    private ListView<String> accompagnementListView;

    @FXML
    private ListView<String> boissonListView;

    @FXML
    private Button validerButton;

    @FXML
    private Button annulerButton;



    @FXML
    private ComboBox<String> burgerComboBox;

    @FXML
    private ComboBox<String> sideComboBox;

    @FXML
    private ComboBox<String> drinkComboBox;

    @Override
    public void initialize() {
        burgerComboBox.setItems(FXCollections.observableArrayList(
            "Cheeseburger",
                "Veggie Burger",
                "Chicken Burger"
        ));
        sideComboBox.setItems(FXCollections.observableArrayList(
                "French Fries",
                "Qignon Rings",
                "Nachos"
        ));
        drinkComboBox.setItems(FXCollections.observableArrayList(
                "Ice Tea",
                "Oasis",
                "Mountain Dew"
        ));
    }

    private void ajouterNouvelleCommande() {
        String burger = burgerComboBox.getValue();
        String accompagnement = sideComboBox.getValue();
        String boisson = drinkComboBox.getValue();
        String lieu = ((RadioButton) lieuConsommation.getSelectedToggle()).getText();
        String remarques = remarquesTextArea.getText();
    }

/*    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        burgerListView.setItems(burgers);
        accompagnementListView.setItems(accompagnements);
        boissonListView.setItems(boissons);

        validerButton.setOnAction(event -> validerCommande());
        annulerButton.setOnAction(event -> annulerCommande());
    }*/

    private void validerCommande() {
        String selectedBurger = burgerListView.getSelectionModel().getSelectedItem();
        String selectedAccompagnement = accompagnementListView.getSelectionModel().getSelectedItem();
        String selectedBoisson = boissonListView.getSelectionModel().getSelectedItem();

        if (selectedBurger != null) {
            commandeService.ajouterBurger(selectedBurger);
        }
        if (selectedAccompagnement != null) {
            commandeService.ajouterAccompagnement(selectedAccompagnement);
        }
        if (selectedBoisson != null) {
            commandeService.ajouterBoisson(selectedBoisson);
        }

        if (radioConsoSurPlace.isSelected()) {
            commandeService.ajouterConsoSurPlace();
        } else if (radioConsoEmporte.isSelected()) {
            commandeService.ajouterConsoEmporte();
        }

        commandeService.validerCommande();
    }

    private void annulerCommande() {
        commandeService.annulerCommande();
    }

    public void setRemarquesTextArea(String remarquesTextArea) {
        this.remarquesTextArea = remarquesTextArea;
    }

    public void commander(ActionEvent actionEvent) {
        String burger = burgerComboBox.getValue();
        String accompagnement = sideComboBox.getValue();
        String boisson = drinkComboBox.getValue();
        String lieu = ((RadioButton) lieuConsommation.getSelectedToggle()).getText();
        String remarques = remarquesTextArea;

        StringBuilder sauces = new StringBuilder();
        if (ketchupCheck.isSelected()) sauces.append("Ketchup ");
        if (mayonnaiseCheck.isSelected()) sauces.append("Mayonnaise ");
        if (samouraiCheck.isSelected()) sauces.append("Samourai ");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        burgerListView.setItems(burgers);
        accompagnementListView.setItems(accompagnements);
        boissonListView.setItems(boissons);

        validerButton.setOnAction(event -> validerCommande());
        annulerButton.setOnAction(event -> annulerCommande());
    }
}
