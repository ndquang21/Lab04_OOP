package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Comparator;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList(); // Danh sách Media trong giỏ hàng

    // Thêm một Media vào giỏ hàng
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) { // Kiểm tra trùng lặp bằng equals()
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " đã được thêm vào giỏ hàng.");
        } else {
            System.out.println(media.getTitle() + " đã có trong giỏ hàng.");
        }
    }

    // Xóa Media khỏi giỏ hàng
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
        for (Media media : itemsOrdered) {
            System.out.printf("%d. %s - %s: %.2f $\n",
                    itemsOrdered.indexOf(media) + 1,
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
  public Media searchByTitle(String title) {
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
	return null;
  }
  
//Sắp xếp giỏ hàng theo title (alphabetically)
  public void sortCartByTitle() {
      itemsOrdered.sort(new Comparator<Media>() {
          @Override
          public int compare(Media media1, Media media2) {
              return media1.getTitle().compareTo(media2.getTitle()); // So sánh theo title
          }
      });
      System.out.println("Giỏ hàng đã được sắp xếp theo title.");
  }

  // Sắp xếp giỏ hàng theo cost (giá)
  public void sortCartByCost() {
      itemsOrdered.sort(new Comparator<Media>() {
          @Override
          public int compare(Media media1, Media media2) {
              return Float.compare(media1.getCost(), media2.getCost()); // So sánh theo cost
          }
      });
      System.out.println("Giỏ hàng đã được sắp xếp theo cost.");
  }
  
  public void placeOrder() {
	    if (itemsOrdered.isEmpty()) {
	        System.out.println("Your cart is empty. Cannot place an order.");
	    } else {
	        System.out.println("Order placed successfully.");
	        System.out.println("Total amount: " + totalCost() + " $");
	        itemsOrdered.clear();  // Xóa tất cả media khỏi giỏ hàng sau khi đặt hàng
	        System.out.println("Your cart is now empty.");
	    }
	}

public ObservableList<Media> getItemsOrdered() {
    return itemsOrdered;
}



}
