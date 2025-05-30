package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class ViewStoreController {
    private Store store;
    private Cart cart;
    private Stage stage;

    @FXML
    private GridPane gridPane;

    public ViewStoreController(Store store, Cart cart, Stage stage) {
        this.store = store;
        this.cart = cart;
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
                fxmlLoader.setController(new ItemController(cart, store));
                Parent anchorPane = fxmlLoader.load();
                ItemController controller = fxmlLoader.getController();
                controller.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void btnViewCartPressed() {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(cart, store, stage));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}