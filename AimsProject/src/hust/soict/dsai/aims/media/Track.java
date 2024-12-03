package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter và setter cho title và length
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Implement phương thức play
    @Override
    public void play() {
        if (this.length > 0) {
            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length + " minutes");
        } else {
            System.out.println("ERROR: Track length is 0 or less. Cannot play.");
        }
    }

    // Override equals để so sánh track by title and length
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track = (Track) obj;
        return title.equalsIgnoreCase(track.title) && length == track.length; // So sánh title và length
    }

    // Override hashCode to ensure consistent hashing when overriding equals
    @Override
    public int hashCode() {
        int result = title.toLowerCase().hashCode();
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Track: %s (%d mins)", title, length);
    }
}
