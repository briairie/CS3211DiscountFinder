package edu.westga.cs3211.discountFinder.view.codebehind;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Collection;

import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.Item;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	CS 3211
 * @version Fall 2021
 */
public class MainWindow {       
	private DiscountFinder discountFinder;
	
	public static final String NO_MATCHES_TEXT = "No matches";

	@FXML
	private TextField searchbar;

	@FXML
	private Button addFilterButton;

	@FXML
	private Button clearFilter;

	@FXML
	private Label itemLabel;

	@FXML
	private ListView<Item> resultListView;

	@FXML
	void filterName(ActionEvent event) {
		this.filterByName();
	}

	private void filterByName() {
		Collection<Item> filteredItems = this.discountFinder.filter(this.searchbar.textProperty().getValue());
	    this.resultListView.setItems(FXCollections.observableArrayList(filteredItems));
	}
	
	/**
	 * Handle initialization checks for the JavaFX components, and perform any
	 * necessary custom initialization.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	@FXML
	public void initialize() {
		this.discountFinder = new DiscountFinder();
		this.resultListView.setItems(FXCollections.observableArrayList(this.discountFinder.getItems()));
		this.searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
			this.filterByName();
		});
	}
}
