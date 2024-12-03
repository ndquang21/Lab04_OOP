package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DVD;

public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Tạo DVD
        DVD dvd1 = new DVD(0, "The Matrix", "Sci-Fi", 19.99f, "The Wachowskis", 136);
        DVD dvd2 = new DVD(0, "Inception", "Sci-Fi", 14.99f, "Christopher Nolan", 148);
        DVD dvd3 = new DVD(0, "Interstellar", "Sci-Fi", 24.99f, "Christopher Nolan", 169);
        
        DVD[] dvdArray = {
        	    new DVD(0, "Doraemon", "Anime", 19.99f, "FFF", 136),
        	    new DVD(0, "Naruto", "Anime", 19.99f, "FFF", 136)
        };

        // Thêm DVD vào giỏ hàng
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(dvdArray);

        // Hiển thị tổng giá của các DVD trong giỏ hàng
        System.out.println("Tổng giá của các DVD trong giỏ hàng: " + cart.totalCost());

        // Xóa một DVD khỏi giỏ hàng
        cart.removeMedia(dvd2);

        // Hiển thị tổng giá sau khi xóa
        System.out.println("Tổng giá của các DVD trong giỏ hàng sau khi xóa: " + cart.totalCost());
        
        // In giỏ hàng
        cart.printCart();
        
        // Tìm kiếm theo ID
        System.out.println("\nTìm kiếm theo ID:");
        cart.searchByID(1); // Tìm DVD với ID 1
        cart.searchByID(2); // Tìm DVD id 2 không tồn tại do đã xóa

        // Tìm kiếm theo tiêu đề
        System.out.println("\nTìm kiếm theo tiêu đề:");
        cart.searchByTitle("Doraemon"); // Tìm DVD có tiêu đề "Doraemon"
        cart.searchByTitle("Avatar");    // Tìm DVD không tồn tại
    }
}
