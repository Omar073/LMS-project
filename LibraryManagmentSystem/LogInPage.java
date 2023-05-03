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
                System.out.print("Password: ");
                String password = scanner.nextLine();
                validateCredentials(userID, password, Library.persons);
                System.out.println("Login successful!");
                printWelcomeMessage(userID, Library.persons);
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid user ID.");
                scanner.nextLine(); // consume the invalid input
            } catch (InvalidCredentialsException e) {
                System.out.println("Login failed: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }


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
                // check if the person is a admin
                if (person.getIsAdmin())
                {
                    System.out.println("You are an admin");
                    adminpage(person);

                }
                else
                {
                    System.out.println("You are a user");
                    userpage(person);
                }
               
                return;
            }
        }
    }

    public static void adminpage(Person person){
        if(person instanceof Librarian) {
            AdminPage.AdminPage();
        }
    }

    public static void userpage (Person person){
        if(person instanceof Reader) {
            UserPage.UserPage();
        }
    }
}

class InvalidCredentialsException extends Exception {

    public InvalidCredentialsException(String errorMessage) {
        super(errorMessage);
    }

}
