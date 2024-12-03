package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      

        // Hiển thị menu chính
        while (true) {
            showMenu(scanner);
        }
    }

    // Hiển thị menu chính
    public static void showMenu(Scanner scanner) {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        switch (choice) {
            case 1:
                storeMenu(scanner);
                break;
            case 2:
                updateStore(scanner);
                break;
            case 3:
                cartMenu(scanner);
                break;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Hiển thị menu cửa hàng
    public static void storeMenu(Scanner scanner) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    cart.printCart();
                    break;
                case 0:
                    return; // Trở về menu chính
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Xem chi tiết media
    public static void seeMediaDetails(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(scanner, media);
        } else {
            System.out.println("Media not found.");
        }
    }

    // Menu các lựa chọn khi xem chi tiết media
    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println(media.getTitle() + " added to cart.");
                    break;
                case 2:
                    media.play();
                    break;
                case 0:
                    return; // Trở về menu cửa hàng
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Thêm media vào giỏ hàng
    public static void addMediaToCart(Scanner scanner) {
        System.out.println("Enter the title of the media to add to the cart:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    // Phát media
    public static void playMedia(Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            media.play();
        } else {
            System.out.println("Media not found.");
        }
    }
    



    // Cập nhật cửa hàng (thêm hoặc xóa media)
    public static void updateStore(Scanner scanner) {
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.print("Please choose a number: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        switch (choice) {
            case 1:
                addMediaToStore(scanner);
                break;
            case 2:
                removeMediaFromStore(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Thêm media vào cửa hàng
    public static void addMediaToStore(Scanner scanner) {
        System.out.println("Enter the media type to add (DVD/Book/CD):");
        String type = scanner.nextLine();
        System.out.println("Enter title, category, and cost:");
        String title = scanner.nextLine();
        String category = scanner.nextLine();
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Clear the buffer

        if (type.equalsIgnoreCase("DVD")) {
            System.out.println("Enter director and length:");
            String director = scanner.nextLine();
            int length = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            DVD dvd = new DVD(0, title, category, cost, director, length);
            store.addMedia(dvd);
        } else if (type.equalsIgnoreCase("Book")) {
            Book book = new Book(0, title, category, cost);
            store.addMedia(book);
        } else if (type.equalsIgnoreCase("CD")) {
            System.out.println("Enter artist and length:");
            String artist = scanner.nextLine();
            int length = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            CompactDisc cd = new CompactDisc(0, title, category, cost, length, "", artist);
            store.addMedia(cd);
        } else {
            System.out.println("Invalid media type.");
        }
    }

    // Xóa media khỏi cửa hàng
    public static void removeMediaFromStore(Scanner scanner) {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    // Xem giỏ hàng hiện tại
    public static void cartMenu(Scanner scanner) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    filterMediasInCart(scanner);
                    break;
                case 2:
                    sortMediasInCart(scanner);
                    break;
                case 3:
                    removeMediaFromCart(scanner);
                    break;
                case 4:
                    playMedia(scanner);
                    break;
                case 5:
                    //placeOrder();
                    break;
                case 0:
                    return; // Trở về menu chính
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Lọc media trong giỏ hàng
    public static void filterMediasInCart(Scanner scanner) {
        System.out.println("Filter by: 1. ID 2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        if (choice == 1) {
            System.out.print("Enter ID to filter by: ");
            int id = scanner.nextInt();
            cart.searchByID(id);
        } else if (choice == 2) {
            System.out.print("Enter title to filter by: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Sắp xếp media trong giỏ hàng
    public static void sortMediasInCart(Scanner scanner) {
        System.out.println("Sort by: 1. Title 2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        if (choice == 1) {
            cart.sortCartByTitle();
        } else if (choice == 2) {
            cart.sortCartByCost();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Xóa media khỏi giỏ hàng
    public static void removeMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }
}
