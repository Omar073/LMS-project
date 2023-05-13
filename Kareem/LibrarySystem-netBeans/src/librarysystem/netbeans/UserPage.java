/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystem.netbeans;

/**
 *
 * @author a
 */
import java.util.Scanner;

public class UserPage {
    public static void UserPage(Person person){


        Scanner scanner = new Scanner(System.in);

        Reader reader =  (Reader) person;
        int choice;

        
        while(true) {
            System.out.println("\nWelcome to the User Page");
            System.out.println("1. View all books");
            System.out.println("2. View Cart");
            System.out.println("3. Rent a book");
            System.out.println("4. Return a book");
            System.out.println("5. Search book");
            System.out.println("6. Search User");
            System.out.println("7. Logout");
            
            System.out.println("Please select an option");
            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1:
                    Book.displayAllBooks(Library.books);
                    break;
                case 2:
                    Reader.View_cart(reader);
                    break;
                case 3:
                    reader.rent_book(reader ,Library.persons, Library.books);
                    break;
                case 4:
                    reader.removeBookFromCart(reader);
                    break;
                case 5:
                    reader.search_book(Library.books);
                    break;
                case 6:
                    reader.search_user(Library.persons);
                    break;
                case 7:
                    System.out.println("Logged out successfully!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
