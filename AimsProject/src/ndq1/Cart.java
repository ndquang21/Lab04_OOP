package ndq1;
public class Cart {
    private int qtyOrdered = 0;      // Số lượng DVD đã được đặt hàng
    private DVD[] itemsOrdered;      // Mảng chứa các DVD đã đặt hàng

    // Constructor
    public Cart() {
        itemsOrdered = new DVD[10];  // Giả sử giỏ hàng có sức chứa 10 DVD
    }

    // Thêm DVD vào giỏ hàng
    public void addDVD(DVD disc) {
        if (qtyOrdered < itemsOrdered.length) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println(disc.getTitle() + " đã được thêm vào giỏ hàng.");
        } else {
            System.out.println("Giỏ hàng đã đầy.");
        }
    }

    // Xóa DVD khỏi giỏ hàng
    public void removeDVD(DVD disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                found = true;
                // Dịch chuyển các phần tử còn lại
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println(disc.getTitle() + " đã được xóa khỏi giỏ hàng.");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD không có trong giỏ hàng.");
        }
    }

    // Tính tổng giá của các DVD trong giỏ hàng
    public float totalPrice() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getPrice();
        }
        return total;
    }
}
