package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        //  Print
        cart.print();

        // Search by ID
        System.out.println("\nSearch by ID():");
        cart.searchByID(dvd1.getID());
        cart.searchByID(2);
        cart.searchByID(99);

        // Search by title
        System.out.println("\nSearch by title():");
        cart.searchByTitle("lio");
        cart.searchByTitle("wars star");
        cart.searchByTitle("harry potter");
    }
}
