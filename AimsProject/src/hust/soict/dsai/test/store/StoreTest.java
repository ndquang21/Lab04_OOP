package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo cửa hàng
        Store store = new Store();

        // Tạo một số DVD mẫu
        DVD dvd1 = new DVD(0, "Jungle", "Adventure", 10.5f, "Author A", 90);
        DVD dvd2 = new DVD(0, "Cinderella", "Animation", 15.0f, "Author B", 80);
        DVD dvd3 = new DVD(0, "Avengers", "Action", 20.0f, "Marvel", 120);

        // Thêm DVD vào cửa hàng
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Xóa DVD khỏi cửa hàng
        System.out.println("\nXóa DVD khỏi cửa hàng:");
        store.removeMedia(dvd2); // Xóa DVD "Cinderella"
    }
}
