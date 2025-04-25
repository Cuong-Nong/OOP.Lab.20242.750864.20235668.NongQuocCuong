package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;


public class Store {
    private ArrayList<Media> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added Media: " + media.getTitle() + " to the store.");
    }

    public void removeMedia(Media media) {
        boolean found = itemsInStore.remove(media);
        if (found) {
            System.out.println("Remove Media: " + media.getTitle() + " from the store.");
        } else {
            System.out.println("Not found Media " + media.getTitle() + " in the store.");
        }
    }

    public int getItemCount() {
        return itemsInStore.size();
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
