package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media{
	private ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost); // Gọi constructor của lớp cha
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }
    
    
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found in the list.");
        }
    }
    
    @Override
    public void viewDetails() {
        System.out.println("Book Title: " + this.getTitle());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Authors: " + String.join(", ", authors));
        System.out.println("Cost: " + this.getCost());
    }

    @Override
    public String toString() {
        return "Book - Title: " + this.getTitle() +
               ", Category: " + this.getCategory() +
               ", Authors: " + String.join(", ", authors) +
               ", Price: " + this.getCost() + " $";
    }

}

