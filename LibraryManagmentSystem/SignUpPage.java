import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SignUpPage {

    public static void SignUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the sign up page!\nPlease enter your personal details:");
        // Prompt user to enter their personal details
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        // this next gender part can be easily replaced in GUI by giving the user only two options to choose from
        String Gender = "";
        boolean validGender = false;
        while (!validGender) {
            System.out.print("Gender: ");
            Gender = scanner.nextLine().toLowerCase();
            if (Gender.equals("male") || Gender.equals("female")) {
                validGender = true;
            } 
            else {
                System.out.println("Please enter a valid gender (Male/Female).");
            }
        }   
        System.out.print("Address: ");
        String Address = scanner.nextLine();
        // Prompt user to enter their phone number
        int PhoneNumber = 0;
        // add exception to check if a user already has this phone number
        boolean validPhoneNumber = false;
        while (!validPhoneNumber) {
            try {
                System.out.print("Phone Number: ");
                PhoneNumber = Integer.parseInt(scanner.nextLine());
                validPhoneNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid phone number.");
                // we can also make a custom exception that verifies if this a valid egypian phone number 01#########
            }
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Check if the user ID is already taken
        int userID = 0;
        boolean userIDTaken = true;

        while (userIDTaken) {
            try {
                System.out.print("User ID: ");
                userID = Integer.parseInt(scanner.nextLine());
                checkUserID(userID, Library.persons);
                userIDTaken = false;
            } catch (UserIDAlreadyTakenException e) {
                System.out.println("Sorry!: " + e.getMessage());
                userIDTaken = true;
            }
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();



        // Create a new user object and add it to the ArrayList of persons
        Library.persons.add(new Reader(userID, password, false, firstName, lastName, Gender, Address, PhoneNumber, email, false));

        System.out.println("Sign up successful!\n");
        
        //temporary solution
        Reader reader = new Reader();
        reader.rent_book(userID, Library.persons, Library.books);
        // Librarian.rent_book(userID, Library.persons, Library.books);
    }

    static public void checkUserID(int userID, ArrayList<Person> persons) throws UserIDAlreadyTakenException {
        for (Person person : persons) {
            if (person.getuser_ID() == userID) {
                throw new UserIDAlreadyTakenException();
            }
        }
    }
}

class UserIDAlreadyTakenException extends Exception {

    public UserIDAlreadyTakenException() {
        super("This user ID is already taken by another user.");
    }
}


// import java.util.ArrayList;
// import java.util.Scanner;

// public class SignUpPage {

//     static public void SignUp() {

//         Scanner scanner = new Scanner(System.in);

//         int user_ID;
//         String password;
//         String FirstName;
//         String LastName;
//         String Gender;
//         String Address;
//         int PhoneNumber;
//         String Email;

//         // Prompt user to enter their information
//         System.out.print("First name: ");
//         String firstName = scanner.nextLine();

//         System.out.print("Last name: ");
//         String lastName = scanner.nextLine();

//         int userID = 0;
//         boolean validInput = false;
//         while (!validInput) {
//             try {
//                 System.out.print("User ID: ");
//                 userID = Integer.parseInt(scanner.nextLine());
//                 validInput = true;
//             } catch (NumberFormatException e) {
//                 System.out.println("Invalid input. Please enter a valid user ID.");
//             }
//         }

//         System.out.print("Password: ");
//         String password = scanner.nextLine();

//         // Create a new person object with the user's information
//         Person newPerson = new Person(firstName, lastName, userID, password);

//         // Add the new person to the list of persons in the library
//         Library.persons.add(newPerson);

//         System.out.println("Sign up successful!");
//         scanner.close();
//     }
// }


