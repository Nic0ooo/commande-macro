package fr.esgi.burger.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.esgi.burger.App;
import fr.esgi.burger.business.Boisson;
import fr.esgi.burger.business.Commande;
import fr.esgi.burger.service.AccompagnementService;
import fr.esgi.burger.service.BoissonService;
import fr.esgi.burger.service.BurgerService;
import fr.esgi.burger.service.CommandeService;
import fr.esgi.burger.service.impl.AccompagnementServiceImpl;
import fr.esgi.burger.service.impl.BoissonServiceImpl;
import fr.esgi.burger.service.impl.BurgerServiceImpl;
import fr.esgi.burger.service.impl.CommandeServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class CommandeController implements Initializable {

	private BurgerService burgerService = new BurgerServiceImpl();
	private AccompagnementService accompagnementService = new AccompagnementServiceImpl();
	private BoissonService boissonService = new BoissonServiceImpl();

	// principes SOLID : D : on injecte à un objet les dépendances dont il a besoin
	private CommandeService commandeService = new CommandeServiceImpl(burgerService, accompagnementService, boissonService);
	
		private ObservableList<String> burgers = FXCollections.observableArrayList(burgerService.recupererNomBurgers());

		private ObservableList<String> accompagnements = FXCollections.observableArrayList(accompagnementService.recupererNomAccompagnements());

		private ObservableList<String> boissons = FXCollections.observableArrayList(boissonService.recupererNomBoissons());
	
	@FXML
	private RadioButton surPlaceRadioButton;
	
	@FXML
	private ToggleGroup lieuConsommation;
	
	@FXML 
	private ComboBox<String> burgerComboBox;
	
	@FXML 
	private ComboBox<String> accompagnementComboBox;
	
	@FXML 
	private ComboBox<String> boissonComboBox;
	
	@FXML
	private TextArea remarquesTextArea;
	
	@FXML
	private CheckBox ketchupCheckBox;

	@FXML
	private CheckBox mayonnaiseCheckBox;

	@FXML
	private CheckBox samouraiCheckBox;

	public CommandeController() {
		burgerService.ajouterBurgers();
	}

	@FXML
	private void commander() throws IOException {
		boolean estSurPlace = false;

		if (lieuConsommation.getSelectedToggle().equals(surPlaceRadioButton)) {
			estSurPlace = true;
		}

		commandeService.ajouterCommande(estSurPlace, burgerComboBox.getValue(), accompagnementComboBox.getValue(), boissonComboBox.getValue(), remarquesTextArea.getText());
		/*

		if (ketchupCheckBox.isSelected()) {
			commande.getSauces().add("Ketchup");
		}
		if (mayonnaiseCheckBox.isSelected()) {
			commande.getSauces().add("Mayonnaise");
		}
		if (samouraiCheckBox.isSelected()) {
			commande.getSauces().add("Samouraï");
		}
		*/
		System.out.println(commandeService.recupererCommandes());

		App.setRoot("listeDesCommandes");
	}

	/**
	 * Cette méthode initialise les informations qui seront envoyées à la vue
	 */
	// @Override est une annotation Java
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		surPlaceRadioButton.setSelected(true);
		
		burgerComboBox.setItems(burgers);
		
		// On envoie à la liste déroulante la collection d'accompagnements
		accompagnementComboBox.setItems(accompagnements);
		
		boissonComboBox.setItems(boissons);
		
	}
}