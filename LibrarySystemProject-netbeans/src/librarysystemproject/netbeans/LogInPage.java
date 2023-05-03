/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemproject.netbeans;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogInPage {

    static public void Login() {

        Scanner scanner = new Scanner(System.in);

        int userID = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                // Prompt user to enter their username and password
                System.out.print("User ID: ");
                userID = Integer.parseInt(scanner.nextLine());
                validInput = true;
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid user ID.");
                scanner.nextLine(); // consume the invalid input
            }
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Validate user's credentials
        try {
            validateCredentials(userID, password, Library.persons);
            System.out.println("Login successful!");
            printWelcomeMessage(userID, Library.persons);
        } catch (InvalidCredentialsException e) {
            System.out.println("Login failed: " + e.getMessage());
        }

        scanner.close();
    }

    public static void validateCredentials(int userID, String password, ArrayList<Person> persons) throws InvalidCredentialsException {

        // Check if the username and password match any of the persons in the ArrayList
        for (Person person : persons) {
            if (person.getuser_ID() == userID && person.getPassword().equals(password)) {
                return;
            }
        }
        // Throw an InvalidCredentialsException if the credentials are invalid
        throw new InvalidCredentialsException("Invalid username or password");

    }

    public static void printWelcomeMessage(int userID, ArrayList<Person> persons) {
        // Find the person in the ArrayList with the given userID
        for (Person person : persons) {
            if (person.getuser_ID() == userID) {
                // Print the welcome message
                System.out.println("Hello, " + person.getFirstName() + "!");
                return;
            }
        }
    }
}

class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException(String errorMessage) {
        super(errorMessage);
    }

}
