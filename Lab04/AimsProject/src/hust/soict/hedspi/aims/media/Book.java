package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

	public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }

    public Book(int id, String title) {
        super(id, title);
        this.authors = new ArrayList<>();
    }
	
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " has been added to the book " + getTitle());
        } else {
            System.out.println("Author " + authorName + " is already in the book " + getTitle());
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " has been removed from the book " + getTitle());
        } else {
            System.out.println("Author " + authorName + " is not in the book " + getTitle());
        }
	}

    @Override
    public String toString() {
        return "Book - " + super.toString() + ", Authors: " + authors;
    }
}
