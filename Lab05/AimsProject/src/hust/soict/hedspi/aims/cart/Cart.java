package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public Cart() {
        itemsOrdered = FXCollections.observableArrayList();
    }
   
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added!");
        } else {
            System.out.println("The cart is almost full!");
        }
    }

    public void removeMedia(Media media) {
        boolean found = itemsOrdered.remove(media);
        if (found) {
            System.out.println("The media " + media.getTitle() + " has been removed!");
        } else {
            System.out.println("The media was not found!");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.getClass().getSimpleName() + " - " + media.getTitle() + " - " +
                    (media.getCategory() != null ? media.getCategory() : "N/A") + " - " + media.getCost() + " $");
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("***************************************************");
    }

    public void printSortedByTitleCost() {
        ArrayList<Media> sortedItems = new ArrayList<>(itemsOrdered);
        Collections.sort(sortedItems, Media.COMPARE_BY_TITLE_COST);
        System.out.println("***********************CART (Sorted by Title, then Cost)***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < sortedItems.size(); i++) {
            Media media = sortedItems.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("*******************************************************************************");
    }

    public void printSortedByCostTitle() {
        ArrayList<Media> sortedItems = new ArrayList<>(itemsOrdered);
        Collections.sort(sortedItems, Media.COMPARE_BY_COST_TITLE);
        System.out.println("***********************CART (Sorted by Cost, then Title)***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < sortedItems.size(); i++) {
            Media media = sortedItems.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("*******************************************************************************");
    }
    
    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getID() == id) {
                System.out.println("Found: " + media.getClass().getSimpleName() + " - " + media.getTitle() + " - " +
                        (media.getCategory() != null ? media.getCategory() : "N/A") + " - " + media.getCost() + " $");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media with ID " + id + " found in the cart.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null && media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: " + media.getClass().getSimpleName() + " - " + media.getTitle() + " - " +
                        (media.getCategory() != null ? media.getCategory() : "N/A") + " - " + media.getCost() + " $");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with title matching \"" + title + "\" found in the cart.");
        }
    }
    
}
