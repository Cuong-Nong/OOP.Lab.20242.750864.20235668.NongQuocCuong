package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;


public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Create sample DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // Add DVD
        System.out.println("Add DVD:");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Remove DVD
        System.out.println("\nRemove DVD:");
        store.removeMedia(dvd2);
        store.removeMedia(new DigitalVideoDisc("Harry Potter"));
    }
}
