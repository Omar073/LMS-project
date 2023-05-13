/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package librarysystem.netbeans;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author a
 */
public class LibrarySystemNetBeans  {
    
  public static void main(String[] args) throws Exception {

    System.out.println("                 Welcome to the Library Management System!");

    Scanner scanner = new Scanner(System.in);

    Library library = new Library();

    // while (!validInput) {
    //   System.out.println("Enter '1' to log in or '2' to sign up:");
    //   String input = scanner.nextLine().trim();
    //   if (input.equals("1")) {
    //     LogInPage.Login();
    //     validInput = true;
    //   } else if (input.equals("2")) {
    //     SignUpPage.SignUp();
    //     validInput = true;
    //   } else {
    //     System.out.println("Invalid input. Please enter '1' to log in or '2' to sign up.");
    //   }
    // }

    int choice = 0;
    boolean validInput = false;

    while (!validInput) {
        try {
            System.out.print("Enter '1' to log in or '2' to sign up: ");
            choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    LogInPage.Login();
                    validInput = true;
                    break;
                case 2:
                    SignUpPage.SignUp();
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter '1' to log in or '2' to sign up.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter '1' to log in or '2' to sign up.");
            scanner.nextLine(); // consume the invalid input
        }
    }

    scanner.close();
  }
}
