package ndq1;

public class Store {
    private DVD[] itemsInStore; // Mảng chứa danh sách DVD trong cửa hàng
    private int qtyInStore = 0; // Số lượng DVD hiện tại trong cửa hàng
    private static final int MAX_CAPACITY = 500; // Giả sử cửa hàng chứa tối đa 500 DVD

    // Constructor
    public Store() {
        itemsInStore = new DVD[MAX_CAPACITY];
    }

    // Thêm DVD vào cửa hàng
    public void addDVDinStore(DVD disc) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println(disc.getTitle() + " đã được thêm vào cửa hàng.");
        } else {
            System.out.println("Cửa hàng đã đầy");
        }
    }

    // Xóa DVD khỏi cửa hàng
    public void removeDVDinStore(DVD disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(disc)) {
                found = true;
                // Dịch chuyển các phần tử còn lại
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Xóa phần tử cuối cùng
                qtyInStore--;
                System.out.println(disc.getTitle() + " đã được xóa khỏi cửa hàng.");
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy DVD trong cửa hàng.");
        }
    }
}

