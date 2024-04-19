import java.util.ArrayList;
import java.util.Scanner;

public class Book {

  static Scanner scanner = new Scanner(System.in);
    
  private String book_Title;
  private int book_ID;
  private String Author;
  private int Price;
  private int Quantity;
  // public int[] order_List; // array of ids of users who ordered the book

  // default constructor
  public Book() {}

  // constructor
  public Book(String book_Title, int id, String Author, int Price, int Quantity) {
    this.book_Title = book_Title;
    this.book_ID = id;
    this.Author = Author;
    this.Price = Price;
    this.Quantity = Quantity;
  }

  // setters
  public void setbook_Title(String book_Title) {
    this.book_Title = book_Title;
  }

  public void setBookID(int id) {
    this.book_ID = id;
  }

  public void setAuthor(String Author) {
    this.Author = Author;
  }

  public void setPrice(int price) {
    this.Price = price;
  }

  public void setQuantity(int Quantity) {
    this.Quantity = Quantity;
  }

  // getters
  public String getbook_Title() {
    return this.book_Title;
  }

  public int getBookID() {
    return this.book_ID;
  }

  public String getAuthor() {
    return this.Author;
  }

  public int getPrice() {
    return this.Price;
  }

  public int getQuantity() {
    return this.Quantity;
  }

  //display book info
  public static void displayBookInfo(Book b) {
    System.out.println("\nBook Name: " + b.book_Title);
    System.out.println("Book ID: " + b.book_ID);
    System.out.println("Book Author: " + b.Author);
    System.out.println("Book Price: " + b.Price);
    System.out.println("Book Quantity: " + b.Quantity);
  }

  // display all books
  public static void displayAllBooks(ArrayList<Book> books) {
    for (Book b : books) {
      displayBookInfo(b);
    }
  }

  //Update book info
  public static void updateBook(Book b) {
    System.out.print("Enter new book name: ");
    b.setbook_Title(scanner.nextLine().trim());
    System.out.print("Enter new book ID: ");
    b.setBookID(Integer.parseInt(scanner.nextLine().trim()));
    System.out.print("Enter new book Author: ");
    b.setAuthor(scanner.nextLine());
    System.out.print("Enter new book Price: ");
    b.setPrice(Integer.parseInt(scanner.nextLine().trim()));
    System.out.print("Enter new book Quantity: ");
    b.setQuantity(Integer.parseInt(scanner.nextLine().trim()));
    
    System.out.println("Book updated successfully");
  }

  public Book searchBookinCart(Person person){
    System.out.print("Enter book Name or ID: ");
    String bookKey = scanner.nextLine().trim();
    Book book = null;
    for (Book b : person.book_cart) {
      if (b.getbook_Title().equalsIgnoreCase(bookKey) || b.getBookID() == Integer.parseInt(bookKey)) {
        book = b;
        return book;
      }
    }
    if (book == null) {
      System.out.println("Book not found.");
    }
    return book;
  }
}
