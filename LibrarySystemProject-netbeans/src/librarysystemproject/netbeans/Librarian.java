package librarysystemproject.netbeans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a
 */
import java.util.ArrayList;

public class Librarian extends Person{

  //constructor
  public Librarian(int user_ID, String password, boolean isAdmin, String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, boolean isBlocked) {
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