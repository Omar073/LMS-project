import java.util.Scanner;


public class AdminPage {

    public static void AdminPage(Person person){

        Scanner scanner = new Scanner(System.in);

        Librarian librarian = (Librarian) person; // downcasting

        System.out.println("\nWelcome to the Admin Page");
        System.out.println("Please select an option");
        System.out.println("1. Add a new book");
        System.out.println("2. Remove a book");
        System.out.println("3. Update a book");
        System.out.println("4. Add a new user");
        System.out.println("5. Remove a user");
        System.out.println("6. Update a user");
        System.out.println("7. View all books");
        System.out.println("8. View all users");
        System.out.println("9. Search Users");
        System.out.println("10. Search Books");
        System.out.println("11. View cart");
        System.out.println("12. Add to cart");  // add to cart / rent book
        System.out.println("13. Remove book from cart");
        System.out.println("14. Block User");
        System.out.println("15. Logout");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Librarian.add_book(Library.books);
                break;
            case 2:
                Librarian.remove_book(Library.books);
                break;
            case 3:
                librarian.updateBook();
                break;
            case 4:
                SignUpPage.SignUp();
                break;
            case 5:
                librarian.removeUser();
                break;
            case 6:
                librarian.updateUserinfo();
                break;
            case 7:
                Book.displayAllBooks(Library.books);
                break;
            case 8:
                librarian.viewAllUsers(librarian);
                break;
            case 9:
                librarian.search_user(Library.persons);
                break;
            case 10:
                Book b = librarian.search_book(Library.books);
                Book.displayBookInfo(b);
                break;
            case 11:
                Librarian.View_cart(librarian);
                //we can make it librarian.view_cart() if we want
                break;
            case 12:
                librarian.rent_book(librarian, Library.persons, Library.books);
                break;
            case 13:
                librarian.removeBookFromCart(librarian);
                // serach only in arraylist of cart
                break;
            case 14:
                Person BlockedP = librarian.search_user(Library.persons);
                BlockedP.setIsBlocked(true);
                break;
            case 15:
                System.out.println("Logged out successfully!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option selected. Please try again.");
                AdminPage(person);
                break;
        }

    
    }
}
