import java.util.ArrayList;
import java.util.Scanner;

public class Librarian extends Person{

  static Scanner scanner = new Scanner(System.in);

  // default constructor
  public Librarian() {
  }

  //constructor
  public Librarian(int user_ID, String password, boolean isAdmin, String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, boolean isBlocked) {
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


  static void add_book(ArrayList<Book> books) {

    System.out.print("Enter book name: ");
    String bookName = scanner.nextLine().trim();
    System.out.print("Enter book ID: ");
    int bookId = Integer.parseInt(scanner.nextLine().trim());
    System.out.print("Enter book Author: ");
    String bookAuthor = scanner.nextLine().trim();
    System.out.print("Enter book Price: ");
    int bookPrice = Integer.parseInt(scanner.nextLine().trim());
    System.out.print("Enter book Quantity: ");
    int bookQuantity = Integer.parseInt(scanner.nextLine().trim());
    books.add(new Book(bookName, bookId, bookAuthor, bookPrice, bookQuantity));
    System.out.println("Book added successfully");

  }

  static void remove_book(ArrayList<Book> books) {

    Book book = null;
    Librarian librarian = new Librarian();
    book = librarian.search_book(books);

    if (book == null) {
      System.out.println("Book ID not found. Please enter a valid Book ID.");
      return;
    }

    books.remove(book);
    System.out.println("Book removed successfully");
  }

  static void View_cart(Person person){
    for(Book book : person.getCart()){
      Book.displayBookInfo(book);
    }
  }

  public void updateBook(){
    Book b = null;
    b = search_book(Library.books);
    Book.updateBook(b);
  }

  // @ Override
  // public Person search_user(ArrayList<Person> persons){
  //   System.out.print("Enter user Name or ID you want to search for: ");
  //   String user_key = scanner.nextLine().trim();
  //   Person person = null;
  //   for (Person p : Library.persons) {
  //     if (p.getuser_ID() == Integer.parseInt(user_key) || p.getFirstName().equalsIgnoreCase(user_key)) {
  //       person = p;
  //       return person;
  //     }
  //   }
  //   if (person == null) {
  //     System.out.println("User not found.");
  //   }
  //   return person;
  // }

  @Override
  public Person search_user(ArrayList<Person> persons){
    System.out.print("Enter the FirstName or ID of the user you want to search for: ");
    String user_key = scanner.nextLine().trim();
    Person person = null;
    try {
      int userID = Integer.parseInt(user_key);
      for (Person p : persons) {
        if (p.getuser_ID() == userID) {
          person = p;
          return person;
        }
      }
    } 
    catch (NumberFormatException e) {
      // not a valid integer, search by name instead
      for (Person p : persons) {
        if (p.getFirstName().equalsIgnoreCase(user_key)) {
          person = p;
          return person;
        }
      }
    }
    System.out.println("User not found.");
    return person;
  }

  
  // removeUser
  public void removeUser(){
    Person p = null;
    p = search_user(Library.persons);
    Library.persons.remove(p);
    System.out.println("User removed successfully");
  }

  // UpdateUser
  public void updateUserinfo(){
    Person p = null;
    p = search_user(Library.persons);
    System.out.print("Enter new ID: ");
    p.setuser_ID(Integer.parseInt(scanner.nextLine().trim()));
    // try to implement ID already taken
    System.out.print("Enter new Password: ");
    p.setPassword(scanner.nextLine().trim());
    System.out.print("Enter new First Name: ");
    p.setFirstName(scanner.nextLine().trim());
    System.out.print("Enter new Last Name: ");
    p.setLastName(scanner.nextLine().trim());
    System.out.print("Enter new address: ");
    p.setAddress(scanner.nextLine().trim());
    System.out.print("Enter new Phone Number: ");
    p.setPhoneNumber(Integer.parseInt(scanner.nextLine().trim()));
    System.out.print("Enter new Email: ");
    p.setEmail(scanner.nextLine().trim());
    System.out.println("User updated successfully");
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
