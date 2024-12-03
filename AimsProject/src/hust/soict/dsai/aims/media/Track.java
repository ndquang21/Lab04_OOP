package hust.soict.dsai.aims.media;

public class Track {
    private String title; // Tên bài hát
    private int length;   // Độ dài bài hát

    // Constructor không tham số
    public Track() {
        this.title = "Unknown Title";
        this.length = 0;
    }

    // Constructor với các tham số
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Setter cho title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter cho length
    public int getLength() {
        return length;
    }

    // Setter cho length
    public void setLength(int length) {
        this.length = length;
    }

}
