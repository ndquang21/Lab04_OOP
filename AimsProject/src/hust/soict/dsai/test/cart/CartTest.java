package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DVD;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Tạo DVD
        DVD dvd1 = new DVD("The Lion King", "Animation", 19.99f, "Roger Allers", 136);
        DVD dvd2 = new DVD("Star Wars", "Sci-Fi", 14.99f, "George Lucas", 148);
        DVD dvd3 = new DVD("Aladin", "Animation", 24.99f);      
     

        // Thêm DVD vào giỏ hàng
        cart.addDVD(dvd1);
        cart.addDVD(dvd2);
        cart.addDVD(dvd3);     

        // Xóa một DVD khỏi giỏ hàng
        cart.removeDVD(dvd2);
        
        // In giỏ hàng
        cart.printCart();
        
        // Tìm kiếm theo ID
        System.out.println("\nTìm kiếm theo ID:");
        cart.searchByID(1); // Tìm DVD với ID 1
        cart.searchByID(2); // Tìm DVD id 2 không tồn tại do đã xóa

        // Tìm kiếm theo tiêu đề
        System.out.println("\nTìm kiếm theo tiêu đề:");
        cart.searchByTitle("Aladin"); // Tìm DVD có tiêu đề "Aladin"
        cart.searchByTitle("Avatar");    // Tìm DVD không tồn tại
    }
}
