package hust.soict.dsai.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Sử dụng String (bất biến) gây ra nhiều đối tượng rác
        String str = "";
        for (int i = 0; i < 100_000; i++) {
            str += i; // Mỗi lần nối tạo một đối tượng String mới
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi (GarbageCreator): " + (endTime - startTime) + " ms");
    }
}

