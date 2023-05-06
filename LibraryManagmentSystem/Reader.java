import java.util.ArrayList;
import java.util.Scanner;

public class Reader extends Person{

  Scanner scanner = new Scanner(System.in);

  // default constructor
  public Reader() {
  }

  //constructor
  public Reader(int user_ID, String password, boolean isAdmin, String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, boolean isBlocked) {
    super(user_ID, password, isAdmin, FirstName, LastName, Gender, Address, PhoneNumber, Email, isBlocked);
  }

  @Override
  public void rent_book(Person person, ArrayList<Person> persons, ArrayList<Book> books) {

    Book book = search_book(Library.books);

    if (book.getQuantity() > 0) {
      person.book_cart.add(book);
      book.setQuantity(book.getQuantity() - 1);
      System.out.println("Book " + book.getbook_Title() + " rented successfully by " + person.getFirstName() + " " + person.getLastName());
    } 
    else {
      System.out.println("Sorry! " + book.getbook_Title() + " is not available");
    }
  }


  static void View_cart(Person person){
    for(Book book : person.getCart()){
      Book.displayBookInfo(book);
    }
  }

  @Override
  // remove a book from cart
  public void removeBookFromCart(Person person){
    Book b = new Book();
    b = b.searchBookinCart(person);
    person.book_cart.remove(b);
  }


  // @Override
  // public Book search_book(ArrayList<Book> books) {
  //   System.out.print("Enter book Name or ID: ");
  //   String bookKey = scanner.nextLine().trim();
  //   Book book = null;
  //   for (Book b : Library.books) {
  //     if (b.getbook_Title().equalsIgnoreCase(bookKey) || b.getBookID() == Integer.parseInt(bookKey)) {
  //       book = b;
  //       return book;
  //     }
  //   }
  //   if (book == null) {
  //     System.out.println("Book not found.");
  //   }
  //   return book;
  // }

  //testing
  @Override
  public Book search_book(ArrayList<Book> books) {
    System.out.print("Enter book Name or ID: ");
    String bookKey = scanner.nextLine().trim();
    Book book = null;
    boolean isId = true;

    try {
      int bookId = Integer.parseInt(bookKey);
      for (Book b : Library.books) {
        if (b.getBookID() == bookId) {
          book = b;
          isId = true;
          break;
        }
      }
    }catch (NumberFormatException e) {
      isId = false;
    }

    if (!isId) {
      for (Book b : Library.books) {
        if (b.getbook_Title().equalsIgnoreCase(bookKey)) {
          book = b;
          break;
        }
      }
    }

    if (book == null) {
      System.out.println("Book not found.");
    }

    return book;
  }

  @ Override
  public Person search_user(ArrayList<Person> persons){
    System.out.print("Enter user Name or ID: ");
    String user_key = scanner.nextLine().trim();
    Person person = null;
    for (Person p : Library.persons) {
      if (p.getuser_ID() == Integer.parseInt(user_key) || p.getFirstName().equalsIgnoreCase(user_key)) {
        person = p;
        return person;
      }
    }
    if (person == null) {
      System.out.println("User not found.");
    }
    return person;
  }

  @Override
  public void displayPersonInfo(Person p){
    System.out.println(p.getFirstName());
    System.out.println(p.getLastName());
    System.out.println(p.getPhoneNumber());
    System.out.println(p.getEmail());
  }

  @Override
  public void viewAllUsers(Librarian librarian) {
    for(Person p : Library.persons){
      librarian.displayPersonInfo(p);
    }
  }
}
