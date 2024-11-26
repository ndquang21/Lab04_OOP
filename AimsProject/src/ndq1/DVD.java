package ndq1;

public class DVD {
    private String title;
    private String category;
    private String author;
    private int length;
    private float price;

    // Classifier Member
    private static int nbDigitalVideoDiscs = 0;

    // Instance Member
    private int id;
    
    public DVD(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; // Gán ID duy nhất
    }

    // Constructor với tiêu đề, thể loại và giá
    public DVD(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; // Gán ID duy nhất
    }

    // Constructor với tất cả thuộc tính
    public DVD(String title, String category, float price, String author, int length) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.author = author;
        this.length = length;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; // Gán ID duy nhất
    }
    
    // Setter cho tiêu đề
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Getter cho tiêu đề
    public String getTitle() {
        return title;
    }

    // Getter cho thể loại
    public String getCategory() {
        return category;
    }

    // Getter cho tác giả
    public String getAuthor() {
        return author;
    }

    // Getter cho độ dài
    public int getLength() {
        return length;
    }

    // Getter cho giá
    public float getPrice() {
        return price;
    }
    
    // Getter cho ID
    public int getId() {
        return id;
    }
    
    // Getter cho tổng số DVD đã tạo
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
}