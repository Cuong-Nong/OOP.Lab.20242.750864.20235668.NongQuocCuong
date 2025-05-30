package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;
    private Store store;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private HBox hbox;

    public ItemController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
        hbox.setMargin(btnAddToCart, new javafx.geometry.Insets(0, 0, 0, 60));
    }

    @FXML
    public void btnAddToCartClicked() {
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Added " + media.getTitle() + " to cart.");
        }
    }

    @FXML
    public void btnPlayClicked() throws PlayerException {
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        }
    }
}