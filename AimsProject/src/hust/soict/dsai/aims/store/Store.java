package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>(); // Danh sách Media trong cửa hàng

    // Thêm Media vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " đã được thêm vào cửa hàng.");
        } else {
            System.out.println(media.getTitle() + " đã có trong cửa hàng.");
        }
    }

    // Xóa Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " đã được xóa khỏi cửa hàng.");
        } else {
            System.out.println(media.getTitle() + " không có trong cửa hàng.");
        }
    }

    // Hiển thị tất cả Media trong cửa hàng
    public void displayStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        int index = 1;
        for (Media media : itemsInStore) {
            System.out.printf("%d. %s - %s: %.2f $\n",
                    index++,
                    media.getTitle(),
                    media.getCategory() != null ? media.getCategory() : "Unknown",
                    media.getCost());
        }
        System.out.println("***************************************************");
    }

    // Tìm kiếm Media bằng ID
    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsInStore) {
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

    // Tìm kiếm Media bằng title
    public Media searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Tìm thấy Media:\n" + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy Media với tiêu đề: " + title);
        }
		return null;
    }
}
