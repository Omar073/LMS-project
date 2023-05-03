import java.util.ArrayList;

public class Book {
    
  private String book_Title;
  private int book_ID;
  private String Author;
  private int Price;
  private int Quantity;
  int[] order_List; // array of ids of users who ordered the book

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
  public void displayBookInfo() {
    System.out.println("Book Name: " + this.book_Title);
    System.out.println("Book ID: " + this.book_ID + "\n");
    System.out.println("Book Author: " + this.Author + "\n");
    System.out.println("Book Price: " + this.Price + "\n");
    System.out.println("Book Quantity: " + this.Quantity + "\n");
  }

  // display all books
  public static void displayAllBooks(ArrayList<Book> books) {
    for (Book b : books) {
      b.displayBookInfo();
    }
  }
}
