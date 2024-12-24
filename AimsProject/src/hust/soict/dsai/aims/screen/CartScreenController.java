package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Cart cart;
	
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private Button btnPlaceOrder;
	
	@FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    
    @FXML
    private TableColumn<Media, String> colMediacategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Label lblTotalCost;
    
    @FXML
    void addBook(ActionEvent event) {
        new AddBookToStoreScreen();
    }

    @FXML
    void addCD(ActionEvent event) {
        new AddCompactDiscToStoreScreen();
    }

    @FXML
    void addDVD(ActionEvent event) {
        new AddDigitalVideoDiscToStoreScreen();
    }

    
    public CartScreenController (Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML 
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            });

        // Cập nhật tổng chi phí khi giỏ hàng thay đổi
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            updateTotalCost();
        });

        // Khởi tạo tổng chi phí ban đầu
        updateTotalCost();
    }

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		} 
		else {
			btnPlay.setVisible(false);
		}
	}
	
	private void updateTotalCost() {
	    float totalCost = cart.getItemsOrdered().stream().map(Media::getCost).reduce(0f, Float::sum);
	    lblTotalCost.setText(String.format("%.2f $", totalCost));
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent event) {
	    if (!cart.getItemsOrdered().isEmpty()) {
	        System.out.println("Order placed successfully!");
	        cart.getItemsOrdered().clear();
	    } else {
	        System.out.println("Cart is empty!");
	    }
	}
	
	@FXML
	void btnPlayPressed(ActionEvent event) throws PlayerException {
	    Media media = tblMedia.getSelectionModel().getSelectedItem();
	    if (media instanceof Playable) {
	        ((Playable) media).play();
	    }
	}

}