/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package librarysystemproject.netbeans;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a
 */
public class LibrarySystemProjectNetbeans extends Application {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       

    System.out.println("                 Welcome to the Library Management System!");

    Scanner scanner = new Scanner(System.in);

    Library library = new Library();
    
    LogInPage.Login();

    /*int count = 1;
    for (Book book : books) {
      System.out.println("Book #" + count++);
      book.displayBookInfo();
    }
    

    System.out.println("Enter the book ID you want to add:");
    int bookID = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter the book name you want to add:");
    String bookName = scanner.nextLine();

    // add the book to the first empty spot in the list
    boolean addedBook = false;
    for (int i = 0; i < books.size(); i++) {
      Book book = books.get(i);
      if (book.getBookID() == 0) {
        book.setBookID(bookID);
        book.setBookName(bookName);
        addedBook = true;
        break;
      }
    }
    
    // if no empty spots were found, add the book to the end of the list
    if (!addedBook) {
      Book newBook = new Book();
      newBook.setBookID(bookID);
      newBook.setBookName(bookName);
      books.add(newBook);
    }

    count = 1;
    for (Book book : books) {
      System.out.println("Book #" + count++);
      book.displayBookInfo();
    }

    // add an librarian
    Librarian librarian1 = new Librarian(4968, "password", true, "John", "Doe", "123 Main St", 1234567890, "myemail@email.com", false);

    // rent a book
    System.out.println("enter user ID");
    librarian1.rent_book(4968, book1);

    //search for a book
    System.out.println("Enter the book name you want to search for");
    String bookNameToSearch = scanner.nextLine();
    Book bookToSearch = librarian1.search_book(bookNameToSearch, books);
    if (bookToSearch != null) {
      System.out.println("\nBook found!");
      bookToSearch.displayBookInfo();
    } else {
      System.out.println("\nBook not found");
    }*/

    scanner.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
