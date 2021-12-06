package edu.westga.cs3211.discountFinder.view.codebehind;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collection;

import edu.westga.cs3211.discountFinder.model.DiscountFinder;
import edu.westga.cs3211.discountFinder.model.Item;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author CS 3211
 * @version Fall 2021
 */
public class MainWindow {
	private DiscountFinder discountFinder;
	private String nameFilter = "";
	private String sellerFilter = "";
	private String categoryFilter = "";

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
	private ComboBox<String> filterComboBox;

	@FXML
	void filterName(ActionEvent event) {
		this.nameFilter = this.searchbar.textProperty().getValue();
		this.filter();
	}

	@FXML
	void addFilter(ActionEvent event) {
		this.sellerFilter = this.filterComboBox.getValue();
		this.filter();
	}

	private void filter() {
		Collection<Item> filteredItems = this.discountFinder.filter(this.nameFilter, this.sellerFilter, this.categoryFilter,
				"");
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
			this.filter();
		});
		this.filterComboBox.setItems(FXCollections.observableArrayList(this.discountFinder.getSellers()));
	}
}
