import java.util.Scanner;

public class UserPage {
    public static void UserPage(Person person){


        Scanner scanner = new Scanner(System.in);

        

        System.out.println("\nWelcome to the User Page");
        System.out.println("Please select an option");
        System.out.println("1. View all books");
        System.out.println("2. View Cart");
        System.out.println("3. Rent a book");
        System.out.println("4. Return a book");
        System.out.println("5. Search book");
        System.out.println("6. Search User");
        System.out.println("7. Add book to cart");
        System.out.println("8. Remove book from cart");
        System.out.println("9. Logout");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Book.displayAllBooks(Library.books);
                break;
            case 2:
                // View Cart
                break;
      
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
    }
}
