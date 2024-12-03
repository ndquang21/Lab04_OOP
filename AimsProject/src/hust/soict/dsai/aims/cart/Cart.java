package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>(); // Danh sách media trong giỏ hàng

    // Thêm một Media vào giỏ hàng
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " đã được thêm vào giỏ hàng.");
        } else {
            System.out.println(media.getTitle() + " đã có trong giỏ hàng.");
        }
    }

    // Thêm một danh sách Media vào giỏ hàng
    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println(media.getTitle() + " đã được thêm vào giỏ hàng.");
            } else {
                System.out.println(media.getTitle() + " đã có trong giỏ hàng.");
            }
        }
    }

    // Xóa một Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " đã được xóa khỏi giỏ hàng.");
        } else {
            System.out.println(media.getTitle() + " không có trong giỏ hàng.");
        }
    }

    // Tính tổng giá của các Media trong giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // In giỏ hàng
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.printf("%d. %s - %s: %.2f $\n",
                    index++,
                    media.getTitle(),
                    media.getCategory() != null ? media.getCategory() : "Unknown",
                    media.getCost());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Tìm kiếm bằng ID
    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tìm thấy Media:\n" + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy Media với ID: " + id);
        }
    }

    // Tìm kiếm bằng title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Tìm thấy Media:\n" + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy Media với tiêu đề: " + title);
        }
    }
}
