public class Book {
    
  private String book_Name;
  private int book_ID;
  private int Price;
  int[] order_List; // array of ids of users who ordered the book

  // constructor
  public Book(String name, int id, int Price) {
    this.book_Name = name;
    this.book_ID = id;
    this.Price = Price;
  }

  // setters
  public void setBookName(String name) {
    this.book_Name = name;
  }

  public void setBookID(int id) {
    this.book_ID = id;
  }

  public void setPrice(int price) {
    this.Price = price;
  }

  // getters
  public String getBookName() {
    return this.book_Name;
  }

  public int getBookID() {
    return this.book_ID;
  }

  public int getPrice() {
    return this.Price;
  }

  //display book info
  public void displayBookInfo() {
    System.out.println("Book Name: " + this.book_Name);
    System.out.println("Book ID: " + this.book_ID + "\n");
  }
}
