import java.util.ArrayList;
import java.util.Scanner;

public class Reader extends Person{

  private ArrayList<Book> book_cart = new ArrayList<>();


  Scanner scanner = new Scanner(System.in);

  // default constructor
  public Reader() {
  }

  //constructor
  public Reader(int user_ID, String password, boolean isAdmin, String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, boolean isBlocked) {
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

    Book book = null;
    while (book == null) {
      // make it so that user can search for book by ID or name
      System.out.print("Enter Book ID: ");
      int bookId = scanner.nextInt();
      scanner.nextLine();

      for (Book b : Library.books) {
        if (b.getBookID() == bookId) {
          book = b;
          break;
        }
      }

      if (book == null) {
        System.out.println("Book ID not found. Please enter a valid Book ID.");
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

}
