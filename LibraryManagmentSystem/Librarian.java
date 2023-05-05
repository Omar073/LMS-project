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
      Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the book to rent: ");
        int bookId = scanner.nextInt();

        Book book = null;
        for (Book b : books) {
            if (b.getBookID()==(bookId)) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book with ID " + Book.id + " not found");
            return;
        }

        if (book.getQuantity() > 0) {
            person.book_cart.add(book);
            book.setQuantity(book.getQuantity() - 1);
            System.out.println("Book " + book.getbook_Title() + " rented successfully by " + person.getFirstName() + " " + person.getLastName());
        } else {
            System.out.println("Sorry! " + book.getbook_Title() + " is not available");
        }
      

  /*@Override
  // remove a book from cart
  public void removeBookFromCart(Person person){
    Book b = new Book();
    b = b.searchBookinCart(person);
    person.book_cart.remove(b);
  }/* */


 /*  @Override
  public Book search_book(ArrayList<Book> books) {
    System.out.print("Enter book Name or ID: ");
    String bookKey = scanner.nextLine();
    Book book = null;
    for (Book b : Library.books) {
      if (b.getbook_Title().equals(bookKey) || b.getBookID() == Integer.parseInt(bookKey)) {
        book = b;
        return book;
      }
    }
    if (book == null) {
      System.out.println("Book not found.");
    }
    return book;*/
  }

  @Override
  public Book search_book(ArrayList<Book> books) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Do you want to search by book title or ID? Enter 'title' or 'ID':");
      String searchOption = scanner.nextLine();
  
      if (searchOption.equalsIgnoreCase("title")) {
          System.out.println("Enter book title to search:");
          String query = scanner.nextLine();
  
          for (Book book : books) {
              if (book.getbook_Title().equalsIgnoreCase(query)) {
                  return book;
              }
          }
  
          System.out.println("No book found with the given title.");
      } else if (searchOption.equalsIgnoreCase("ID")) {
          System.out.println("Enter book ID to search:");
          int query = scanner.nextInt();
  
          for (Book book : books) {
              if (book.getBookID() == query) {
                  return book;
              }
          }
  
          System.out.println("No book found with the given ID.");
      } else {
          System.out.println("Invalid search option.");
      }
  
      return null;
  }
  


  static void add_book(ArrayList<Book> books) {

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

  @ Override
  public Person search_user(ArrayList<Person> persons){
    System.out.print("Enter user Name or ID: ");
    String user_key = scanner.nextLine();
    Person person = null;
    for (Person p : Library.persons) {
      if (p.getuser_ID() == Integer.parseInt(user_key) || p.getFirstName().equals(user_key)) {
        person = p;
        return person;
      }
    }
    if (person == null) {
      System.out.println("User not found.");
    }
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
    p.setuser_ID(getuser_ID());
    // try to implement ID already taken
    System.out.print("Enter new Password: ");
    p.setPassword(scanner.nextLine());
    System.out.print("Enter new First Name: ");
    p.setFirstName(scanner.nextLine());
    System.out.print("Enter new Last Name: ");
    p.setLastName(scanner.nextLine());
    System.out.print("Enter new address: ");
    p.setAddress(scanner.nextLine());
    System.out.print("Enter new Phone Number: ");
    p.setPhoneNumber(Integer.parseInt(scanner.nextLine()));
    System.out.print("Enter new Email: ");
    p.setEmail(scanner.nextLine());
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
