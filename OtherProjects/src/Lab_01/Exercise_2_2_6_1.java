package Lab_01;
import java.util.Scanner;

public class Exercise_2_2_6_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị a và b
        System.out.print("Nhập giá trị a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập giá trị b: ");
        double b = scanner.nextDouble();

        // Kiểm tra nếu 'a' bằng 0
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            // Tính nghiệm x
            double x = -b / a;
            System.out.println("Nghiệm của phương trình là x = " + x);
        }

        scanner.close();
    }
}


