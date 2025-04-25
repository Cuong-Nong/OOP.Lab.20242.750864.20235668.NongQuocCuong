package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CompactDisc cd = new CompactDisc(1, "Greatest Hits", "Pop", 15.99f, "Various", "Artist Name");
        cd.addTrack(new Track("Song 1", 180));
        cd.addTrack(new Track("Song 2", 240));

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book(3, "Harry Potter", "Fantasy", 10.99f);
        book.addAuthor("J. K. Rowling");

        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);

        // Start the application
        int choice;
        do {
            showMenu();
            choice = getChoice(0, 3);
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static int getChoice(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please choose a number between " + min + " and " + max + ":");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number:");
            }
        }
    }

    private static void viewStore() {
        int choice;
        do {
            // Display all items in the store
            System.out.println("Items in Store:");
            for (int i = 0; i < store.getItemsInStore().size(); i++) {
                Media media = store.getItemsInStore().get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }

            storeMenu();
            choice = getChoice(0, 4);
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMediaFromStore();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = findMediaInStoreByTitle(title);

        if (media == null) {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
            return;
        }

        System.out.println("Media Details:");
        System.out.println(media.toString());

        int choice;
        do {
            mediaDetailsMenu();
            choice = getChoice(0, 2);
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played (not a CD or DVD).");
                    }
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private static void addMediaToCart() {
        System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();
        Media media = findMediaInStoreByTitle(title);

        if (media == null) {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
            return;
        }

        cart.addMedia(media);
        // Count DVDs in the cart
        int dvdCount = 0;
        for (Media m : cart.getItemsOrdered()) {
            if (m instanceof DigitalVideoDisc) {
                dvdCount++;
            }
        }
        System.out.println("Number of DVDs in the cart: " + dvdCount);
    }

    private static void playMediaFromStore() {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = findMediaInStoreByTitle(title);

        if (media == null) {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played (not a CD or DVD).");
        }
    }

    private static void updateStore() {
        int choice;
        do {
            System.out.println("Update Store Options:");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("Please choose a number: 0-1-2");
            choice = getChoice(0, 2);

            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private static void addMediaToStore() {
        System.out.println("Enter the type of media to add (1: Book, 2: CD, 3: DVD):");
        int type = getChoice(1, 3);

        System.out.println("Enter ID:");
        int id = getChoice(1, Integer.MAX_VALUE);
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        System.out.println("Enter cost:");
        float cost;
        while (true) {
            try {
                cost = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost. Please enter a number:");
            }
        }

        Media media = null;
        switch (type) {
            case 1: // Book
                media = new Book(id, title, category, cost);
                System.out.println("Enter author (or press Enter to finish):");
                String author = scanner.nextLine();
                if (!author.isEmpty()) {
                    ((Book) media).addAuthor(author);
                }
                break;
            case 2: // CD
                System.out.println("Enter director:");
                String director = scanner.nextLine();
                System.out.println("Enter artist:");
                String artist = scanner.nextLine();
                media = new CompactDisc(id, title, category, cost, director, artist);
                System.out.println("Add a track? (y/n):");
                if (scanner.nextLine().toLowerCase().startsWith("y")) {
                    System.out.println("Enter track title:");
                    String trackTitle = scanner.nextLine();
                    System.out.println("Enter track length (seconds):");
                    int trackLength = getChoice(0, Integer.MAX_VALUE);
                    ((CompactDisc) media).addTrack(new Track(trackTitle, trackLength));
                }
                break;
            case 3: // DVD
                System.out.println("Enter director:");
                director = scanner.nextLine();
                System.out.println("Enter length (minutes):");
                int length = getChoice(0, Integer.MAX_VALUE);
                media = new DigitalVideoDisc(title, category, director, length, cost);
                break;
        }

        if (media != null) {
            store.addMedia(media);
        }
    }

    private static void removeMediaFromStore() {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = findMediaInStoreByTitle(title);

        if (media == null) {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
            return;
        }

        store.removeMedia(media);
    }

    private static void seeCurrentCart() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = getChoice(0, 5);
            switch (choice) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private static void filterMediaInCart() {
        System.out.println("Filter Options:");
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        System.out.println("Please choose a number: 1-2");
        int choice = getChoice(1, 2);

        if (choice == 1) {
            System.out.println("Enter ID to filter:");
            int id = getChoice(1, Integer.MAX_VALUE);
            cart.searchByID(id);
        } else {
            System.out.println("Enter title to filter:");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    private static void sortMediaInCart() {
        System.out.println("Sort Options:");
        System.out.println("1. By Title (then Cost)");
        System.out.println("2. By Cost (then Title)");
        System.out.println("Please choose a number: 1-2");
        int choice = getChoice(1, 2);

        if (choice == 1) {
            cart.printSortedByTitleCost();
        } else {
            cart.printSortedByCostTitle();
        }
    }

    private static void removeMediaFromCart() {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = findMediaInCartByTitle(title);

        if (media == null) {
            System.out.println("Media with title \"" + title + "\" not found in the cart.");
            return;
        }

        cart.removeMedia(media);
    }

    private static void playMediaFromCart() {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = findMediaInCartByTitle(title);

        if (media == null) {
            System.out.println("Media with title \"" + title + "\" not found in the cart.");
            return;
        }

        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played (not a CD or DVD).");
        }
    }

    private static void placeOrder() {
        System.out.println("An order has been created!");
        // Empty the cart
        cart = new Cart();
    }

    private static Media findMediaInStoreByTitle(String title) {
        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    private static Media findMediaInCartByTitle(String title) {
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

}
