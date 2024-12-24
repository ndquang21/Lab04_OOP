package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
    private String artist; // Tên nghệ sĩ
    private ArrayList<Track> tracks = new ArrayList<>(); // Danh sách các track

    // Constructor với đầy đủ thông tin
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director); // Gọi constructor lớp cha
        this.artist = artist;
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Thêm track vào CD
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Xóa track khỏi CD
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Tính tổng độ dài của CD
    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum(); // Tính tổng độ dài
    }

    @Override
    public void viewDetails() {
        System.out.println("CD Details:");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Director: " + this.getDirector());
        System.out.println("Total Length: " + this.getLength() + " mins");
        System.out.println("Cost: " + this.getCost() + " $");
        System.out.println("Tracks:");
        for (Track track : tracks) {
            System.out.println("- " + track.getTitle() + " (" + track.getLength() + " mins)");
        }
    }
    
 // Implement phương thức play
    @Override
    public void play() throws PlayerException{
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength() + " minutes");
            for (Track track : tracks) {
                track.play(); // Gọi play() của từng track
            }
        } else {
            throw new PlayerException("ERROR: CD length is 0 or less. Cannot play.");
        }
    }
    
    @Override
    public String toString() {
        String trackList = "";
        for (Track track : tracks) {
            trackList += "\n   - " + track.getTitle() + " (" + track.getLength() + " mins)";
        }
        return "CD - Title: " + this.getTitle() +
               ", Category: " + this.getCategory() +
               ", Artist: " + this.artist +
               ", Length: " + this.getLength() + " mins" +
               ", Price: " + this.getCost() + " $" +
               "\nTracks: " + trackList;
    }

	public Track[] getTracks() {
		// TODO Auto-generated method stub
		return null;
	}
}
