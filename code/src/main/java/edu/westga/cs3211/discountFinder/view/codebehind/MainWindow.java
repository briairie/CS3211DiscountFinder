package edu.westga.cs3211.discountFinder.view.codebehind;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

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

	private Button btnStoreFilter;

    @FXML
    private Button btnCategoryFilter;

    @FXML
    private Button btnDistanceFilter;

	@FXML
    private RadioButton storeRadioBtn;

    @FXML
    private RadioButton categoryRadioBtn;

    @FXML
    private RadioButton distanceRadioBtn;

	@FXML
	void filterName(ActionEvent event) {
		this.nameFilter = this.searchbar.textProperty().getValue();
		this.filter();
	}

	private void addSellerFilter() {

		if (!this.sellerFilter.isEmpty() || this.isFilterEmpty()) {
			return;
		}
		this.sellerFilter = this.filterComboBox.getValue();
		this.filterLabel1.textProperty().setValue("Seller: " + this.sellerFilter);
		this.filterPane1.visibleProperty().set(true);
	}

	private void addCategoryFilter() {

		if (!this.categoryFilter.isEmpty() || this.isFilterEmpty()) {
			return;
		}
		this.categoryFilter = this.filterComboBox.getValue();
		this.filterLabel2.textProperty().setValue("Category: " + this.categoryFilter);
		this.filterPane2.visibleProperty().set(true);
	}

	private boolean isFilterEmpty() {
		String filter = this.filterComboBox.getValue();
		return filter == null || filter.isEmpty();
	}

	@FXML
	void addFilter(ActionEvent event) {
		if (this.categoryRadioBtn.isSelected()) {
			this.addCategoryFilter();
			this.categoryRadioBtn.setSelected(false);
		}
		if (this.storeRadioBtn.isSelected()) {
			this.addSellerFilter();
			this.storeRadioBtn.setSelected(false);
		}
		this.filter();
		this.filterComboBox.setItems(null);
	}

	@FXML
    void clearFilters(ActionEvent event) {
		this.nameFilter = "";
		this.sellerFilter = "";
		this.categoryFilter = "";

		this.filterComboBox.setValue("");

		this.filterPane1.visibleProperty().set(false);
		this.filterPane2.visibleProperty().set(false);
		this.filterPane3.visibleProperty().set(false);

		this.filter();
    }

	private void filter() {
		Collection<Item> filteredItems = this.discountFinder.filter(this.nameFilter, this.sellerFilter,
				this.categoryFilter, this.locationFilter);
		this.resultListView.setItems(FXCollections.observableArrayList(filteredItems));
	}

	@FXML
    void deleteCategoryFilter(ActionEvent event) {
		this.filterComboBox.setValue("");
		this.categoryFilter = "";
		this.filter();
		this.filterPane2.visibleProperty().set(false);
    }

    @FXML
    void deleteDistanceFilter(ActionEvent event) {
    	this.filterComboBox.setValue("");
    	this.locationFilter = 0;
		this.filter();
		this.filterPane3.visibleProperty().set(false);
    }

	@FXML
    void deleteStoreFilter(ActionEvent event) {
    	this.filterComboBox.setValue("");
    	this.sellerFilter = "";
		this.filter();
		this.filterPane1.visibleProperty().set(false);
    }

	@FXML
    void categoryFilterTypeSelected(ActionEvent event) {
		this.filterComboBox.setItems(FXCollections.observableArrayList(this.discountFinder.getCategories()));
    }

    @FXML
    void storeFilterTypeSelected(ActionEvent event) {
    	this.selectStoreList();
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


	}

	private void selectStoreList() {
		this.filterComboBox.setItems(FXCollections.observableArrayList(this.discountFinder.getSellers()));
		this.filterComboBox.setCellFactory(lv ->
        	new ListCell<String>() {
                private HBox graphic;
                {
                    Label label = new Label();
                    label.textProperty().bind(itemProperty());
                    label.setMaxWidth(Double.POSITIVE_INFINITY);

                    Hyperlink cross = new Hyperlink("\u2B50");
                    cross.setVisited(true);
                    cross.setOnAction(event -> {
                	    String item = getItem();
                	    this.setFavoriteSeller(item);
                    });
                    this.graphic = new HBox(label, cross);
                    HBox.setHgrow(label, Priority.ALWAYS);
                    this.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                }
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        this.setGraphic(null);
                    } else {
                        this.setGraphic(this.graphic);
                    }
                }
        	    });
		ComboBoxListViewSkin<String> skin = new ComboBoxListViewSkin<String>(this.filterComboBox);
		skin.setHideOnClick(false);
		this.filterComboBox.setSkin(skin);

	}


	protected void setFavoriteSeller(String item) {
		this.discountFinder.setFavoriteSeller(item);
		this.filter();
	}

}
