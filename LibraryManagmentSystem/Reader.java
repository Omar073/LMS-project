import java.util.ArrayList;

public class Reader extends Person{

  //constructor
  public Reader(int user_ID, String password, boolean isAdmin, String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, boolean isBlocked) {
    super(user_ID, password, isAdmin, FirstName, LastName, Gender, Address, PhoneNumber, Email, isBlocked);
  }

  @Override
  public void rent_book(int userId, Book book) {
    super.rent_book(userId, book);
  }

  @Override
  public Book search_book(String bookName, ArrayList<Book> books) {
    return super.search_book(bookName, books);
  }

}
