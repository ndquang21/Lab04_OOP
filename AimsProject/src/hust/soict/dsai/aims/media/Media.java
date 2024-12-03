package hust.soict.dsai.aims.media;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    // Constructor
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getter and setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // Override equals method to compare media by title
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;  // Same object
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Different classes or null object
        }
        Media media = (Media) obj;
        return title.equalsIgnoreCase(media.title); // Compare by title (case insensitive)
    }

    // Override hashCode to ensure consistent hashing when overriding equals
    @Override
    public int hashCode() {
        return title.toLowerCase().hashCode();
    }
    
    // Abstract method for viewing media details
    public abstract void viewDetails();
    
    public void play() {
        if (this instanceof CompactDisc) {  // Nếu là CD
            CompactDisc cd = (CompactDisc) this;
            if (cd.getLength() > 0) {
                System.out.println("Playing CD: " + cd.getTitle());
                System.out.println("CD length: " + cd.getLength() + " minutes");
                for (Track track : cd.getTracks()) {
                    track.play();
                }
            } else {
                System.out.println("ERROR: CD length is 0 or less. Cannot play.");
            }
        } else if (this instanceof DVD) {  // Nếu là DVD
        	DVD dvd = (DVD) this;
            if (dvd.getLength() > 0) {
                System.out.println("Playing DVD: " + dvd.getTitle());
                System.out.println("DVD length: " + dvd.getLength() + " minutes");
            } else {
                System.out.println("ERROR: DVD length is 0 or less. Cannot play.");
            }
        } else {
            System.out.println("ERROR: This media cannot be played.");
        }
    }

}
