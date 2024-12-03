package hust.soict.dsai.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    // Constructor không tham số
    public Disc() {
        super(0, null, null, 0);
    }

    // Constructor đầy đủ
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost); // Gọi constructor lớp cha
        this.length = length;
        this.director = director;
    }

    // Getters
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    // Setters
    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    @Override
    public void viewDetails() {
        System.out.println("DVD Details:");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + (this.getCategory() != null ? this.getCategory() : "N/A"));
        System.out.println("Director: " + (director != null ? director : "N/A"));
        System.out.println("Length: " + length + " mins");
        System.out.println("Price: " + this.getCost() + " $");
    }
}

