package Lab_01;
import java.util.Scanner;

public class Exercise_6_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String monthInput;
        int month = -1, year = -1;

        String[] monthsFull = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthsAbbreviation = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        while (month == -1) {
            System.out.print("Enter the month (name, abbreviation, or number): ");
            monthInput = scanner.nextLine().trim();

            // Kiểm tra nhập vào có phải số không
            if (monthInput.matches("\\d+")) {
                int monthNum = Integer.parseInt(monthInput);
                if (monthNum >= 1 && monthNum <= 12) {
                    month = monthNum;
                } else {
                    System.out.println("Invalid month. Please enter again.");
                }
            } else {
                // So sánh với tên đầy đủ và viết tắt của các tháng
                for (int i = 0; i < monthsFull.length; i++) {
                    if (monthInput.equalsIgnoreCase(monthsFull[i]) || monthInput.equalsIgnoreCase(monthsAbbreviation[i]) || monthInput.equalsIgnoreCase(monthsAbbreviation[i] + ".")) {
                        month = i + 1;
                        break;
                    }
                }
                if (month == -1) {
                    System.out.println("Invalid month. Please enter again.");
                }
            }
        }

        while (year < 0) {
            System.out.print("Enter the year (4 digits): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Invalid year. Please enter a non-negative number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next();  
            }
        }

        // Xác định năm nhuận
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Tính số ngày trong tháng
        int daysInMonth;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                daysInMonth = 31;
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            case 2:
                daysInMonth = isLeapYear ? 29 : 28;
                break;
            default:
                daysInMonth = 0;
                break;
        }

        // Hiển thị kết quả
        System.out.println("The number of days in " + monthsFull[month - 1] + " " + year + " is: " + daysInMonth);
        
        scanner.close();
    }
}

