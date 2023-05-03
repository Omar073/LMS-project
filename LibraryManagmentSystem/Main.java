import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {

    System.out.println("                 Welcome to the Library Management System!");

    Scanner scanner = new Scanner(System.in);

    Library library = new Library();
    
    LogInPage.Login(); // works

    SignUpPage.SignUp();

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
}