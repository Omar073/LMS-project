import java.util.ArrayList;
import java.util.Scanner;
//kareeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeem
public class Librarian extends Person{

  Scanner scanner = new Scanner(System.in);

  //constructor
  public Librarian(int user_ID, String password, boolean isAdmin, String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, boolean isBlocked) {
    super(user_ID, password, isAdmin, FirstName, LastName, Gender, Address, PhoneNumber, Email, isBlocked);
  }

  @Override
  public void rent_book(int user_ID, ArrayList<Person> persons, ArrayList<Book> books) {
    // Find the person with the given user ID
    Person person = null;
    for (Person p : Library.persons) {
      if (p.getuser_ID() == user_ID) {
        person = p;
        break;
      }
    }

    if (person == null) {
      System.out.println("User with ID " + user_ID + " not found.");
      return;
    }

    System.out.print("Enter book ID: ");
    int bookId = Integer.parseInt(scanner.nextLine());

    Book book = null;
    for (Book b : Library.books) {
      // make it so that user can search for book by ID or name
      if (b.getBookID() == bookId) {
        book = b;
        break;
      }
    }

    if (book.getQuantity() > 0) {
      person.addToCart(book);
      book.setQuantity(book.getQuantity() - 1);
      System.out.println("Book " + book.getbook_Title() + " rented successfully by " + person.getFirstName() + " " + person.getLastName());
    } 
    else {
      System.out.println("Sorry! " + book.getbook_Title() + " is not available");
    }
  }

  @Override
  public Book search_book(String bookName, ArrayList<Book> books) {
    return super.search_book(bookName, books);
  }

  void add_book(ArrayList<Book> books) {

    System.out.print("Enter book name: ");
    String bookName = scanner.nextLine();
    System.out.print("Enter book ID: ");
    int bookId = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter book Author: ");
    String bookAuthor = scanner.nextLine();
    System.out.print("Enter book Price: ");
    int bookPrice = Integer.parseInt(scanner.nextLine());
    System.out.print("Enter book Quantity: ");
    int bookQuantity = Integer.parseInt(scanner.nextLine());
    books.add(new Book(bookName, bookId, bookAuthor, bookPrice, bookQuantity));
    System.out.println("Book added successfully");

  }

  
}