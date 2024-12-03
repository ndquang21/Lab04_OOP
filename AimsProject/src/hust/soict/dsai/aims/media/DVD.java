package hust.soict.dsai.aims.media;

public class DVD extends Disc implements Playable {

    // Classifier Member
    private static int nbDigitalVideoDiscs = 0;

    // Constructor với tất cả thuộc tính
    public DVD(int id, String title, String category, float cost, String director, int length) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director); // Gọi constructor lớp cha
    }

    // Getter cho tổng số DVD đã tạo
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Override phương thức toString() để hiển thị thông tin DVD
    @Override
    public String toString() {
        return String.format("DVD - Title: %s, Category: %s, Director: %s, Length: %d mins, Price: %.2f $",
                this.getTitle(),
                this.getCategory() != null ? this.getCategory() : "N/A",
                this.getDirector() != null ? this.getDirector() : "N/A",
                this.getLength(),
                this.getCost());
    }

    // Phương thức để kiểm tra sự trùng lặp theo tiêu đề
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title); // So sánh không phân biệt hoa thường
    }

    // Phương thức hiển thị thông tin chi tiết (Override từ Media)
    @Override
    public void viewDetails() {
        System.out.println("DVD Details:");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + (this.getCategory() != null ? this.getCategory() : "N/A"));
        System.out.println("Director: " + (this.getDirector() != null ? this.getDirector() : "N/A"));
        System.out.println("Length: " + this.getLength() + " mins");
        System.out.println("Price: " + this.getCost() + " $");
    }

    // Implement phương thức play từ Playable interface
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength() + " minutes");
        } else {
            System.out.println("ERROR: DVD length is 0 or less. Cannot play.");
        }
    }
}
