package ndq1;

public class DVD {
    private String title;
    private String category;
    private String author;
    private int length;
    private float price;

    // Constructor với chỉ tiêu đề
    public DVD(String title) {
        this.title = title;
    }

    // Constructor với tiêu đề, thể loại và giá
    public DVD(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    // Constructor với tất cả thuộc tính
    public DVD(String title, String category, float price, String author, int length) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.author = author;
        this.length = length;
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
}
