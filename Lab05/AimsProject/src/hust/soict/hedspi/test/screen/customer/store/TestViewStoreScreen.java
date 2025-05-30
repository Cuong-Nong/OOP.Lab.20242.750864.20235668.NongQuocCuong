package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Cart cart = new Cart(); // Khởi tạo Cart trong start
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        fxmlLoader.setController(new ViewStoreController(store, cart, primaryStage)); // Truyền Stage vào ViewStoreController
        Parent root = fxmlLoader.load();
        
        primaryStage.setTitle("View Store Screen");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        CompactDisc cd = new CompactDisc(1, "Greatest Hits", "Pop", 15.99f, "Various", "Artist Name");
        cd.addTrack(new Track("Song 1", 180));
        cd.addTrack(new Track("Song 2", 240));
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book(3, "Harry Potter", "Fantasy", 10.99f);
        book.addAuthor("J. K. Rowling");
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);

        launch(args);
    }
}