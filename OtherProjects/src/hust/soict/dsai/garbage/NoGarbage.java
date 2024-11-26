package hust.soict.dsai.garbage;

public class NoGarbage {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // Sử dụng StringBuilder để tránh tạo nhiều đối tượng rác
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            builder.append(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực thi (NoGarbage): " + (endTime - startTime) + " ms");
    }
}

