package edu.westga.cs3211.discountFinder.view.codebehind;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
	private double locationFilter = 0;
	private Pane nextFilterPane;
	private Label nextFilterLabel;

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
    private Pane filterPane1;

    @FXML
    private Label filterLabel1;

    @FXML
    private Pane filterPane2;

    @FXML
    private Label filterLabel2;

    @FXML
    private Pane filterPane3;

    @FXML
    private Label filterLabel3;


	@FXML
	private ListView<Item> resultListView;

	@FXML
	private ComboBox<String> filterComboBox;

	@FXML
	void filterName(ActionEvent event) {
		this.nameFilter = this.searchbar.textProperty().getValue();
		this.filter();
	}

	private void addSellerFilter() {
		if(!this.sellerFilter.isEmpty() || this.filterComboBox.getValue() == null) {
			return;
		}
		this.sellerFilter = this.filterComboBox.getValue();
		this.nextFilterLabel.textProperty().setValue("Seller: " + this.sellerFilter);
		this.nextFilterPane.visibleProperty().set(true);
	}

	private void getFreeFilterPane() {
		if (!this.filterPane1.visibleProperty().getValue()) {
			this.nextFilterPane = this.filterPane1;
			this.nextFilterLabel = this.filterLabel1;
		} else if (!this.filterPane2.visibleProperty().getValue()) {
			this.nextFilterPane = this.filterPane2;
			this.nextFilterLabel = this.filterLabel2;
		} else {
			this.nextFilterPane = this.filterPane3;
			this.nextFilterLabel = this.filterLabel3;
		}
		
	}

	@FXML
	void addFilter(ActionEvent event) {
		this.getFreeFilterPane();
		this.addSellerFilter();
		this.filter();
	}
	
	@FXML
    void clearFilters(ActionEvent event) {
		this.nameFilter = "";
		this.sellerFilter = "";
		this.categoryFilter = "";
		
		this.filterComboBox.setValue("");
		
		this.filter();
    }

	private void filter() {
		Collection<Item> filteredItems = this.discountFinder.filter(this.nameFilter, this.sellerFilter,
				this.categoryFilter, this.locationFilter);
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
		this.filterPane1.visibleProperty().set(false);
		this.filterPane2.visibleProperty().set(false);
		this.filterPane3.visibleProperty().set(false);
		this.resultListView.setItems(FXCollections.observableArrayList(this.discountFinder.getItems()));
		this.searchbar.textProperty().addListener((observable, oldValue, newValue) -> {
			this.filter();
		});
		this.filterComboBox.setItems(FXCollections.observableArrayList(this.discountFinder.getSellers()));
	}
}
