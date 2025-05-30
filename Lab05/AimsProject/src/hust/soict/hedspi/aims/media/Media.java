package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public Media(int id, String title) {
        this(id, title, null, 0.0f);
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;
        Media other = (Media) obj;
        if (this.title == null || other.title == null) return false;
        return this.title.equals(other.title) && Float.compare(this.cost, other.cost) == 0;
    }
    
    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Compared object is null");
        if (this.title == null || other.title == null) throw new NullPointerException("Title is null");
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) return titleComparison;
        return Float.compare(this.cost, other.cost);
    }
    
    @Override
    public String toString() {
        return "Media - ID: " + id + ", Title: " + title + ", Category: " + category + ", Cost: $" + cost;
    }
}