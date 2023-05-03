/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarysystemproject.netbeans;

/**
 *
 * @author a
 */
import java.util.ArrayList;

public class Library {
    
    // array list of persons
    static ArrayList<Person> persons;

    public Library(){

        persons = new ArrayList<Person>();
        
        persons.add(new Librarian(007, "726", true, "Omar", "Ahmed", "Male", "123 Main St", 1234567890, "myemail1@email.com", false));
        persons.add(new Librarian (465, "358", true, "Kareem", "Ahmed", "Male", "123 Main St", 4564356, "newemail2@email.com", false));
        persons.add(new Librarian (645, "866", true, "Youssef", "Mahmoud", "Male", "123 Main St", 472574257, "newemail6@email.com", false));
        persons.add(new Librarian (374, "245", true, "Mohammed", "Fadel", "Male", "123 Main St", 3756753, "newemail3@email.com", false));
        persons.add(new Librarian (745, "755", true, "Basel", "Hany", "Male", "123 Main St", 5467456, "newemail4@email.com", false));
        persons.add(new Librarian (345, "323", true, "Mazen", "Ahmed", "Male", "123 Main St", 245436654, "newemail5@email.com", false));
        persons.add(new Librarian (274, "395", true, "Ahmed", "Elsheikh", "Male", "123 Main St", 2345623, "newemail7@email.com", false));

        persons.add(new Reader(2366, "2366", false, "Mohamed", "Ahmed", "Male", "123 Main St", 1234567890, "reader1@mail.com", false));
        persons.add(new Reader(4562, "243576", false, "Marawan", "Saeed", "Male", "123 Main St", 1234567890, "reader2@mail.com", false));
        persons.add(new Reader(2345, "2475", false, "Sara", "Ali", "Male", "123 Main St", 1234567890, "reader3@mail.com", false));
        persons.add(new Reader(2366, "45678", false, "Ahmed", "Khalid", "Male", "123 Main St", 1234567890, "reader4@mail.com", false));
        persons.add(new Reader(2346, "4257", false, "Nour", "Hassan", "Female", "123 Main St", 1234567890, "reader5@mail.com", false));
        persons.add(new Reader(6789, "12346", false, "Mona", "Adel", "Female", "123 Main St", 1234567890, "reader6@mail.com", false));

        ArrayList<Book> books = new ArrayList<>();

        // adding books to the ArrayList
        books.add(new Book("Java Programming", 1001, 30));
        books.add(new Book("Data Structures", 2674, 100));
        books.add(new Book("C++ for Beginners", 2634, 15));
        books.add(new Book("Web Development", 8564, 50));
        books.add(new Book("Python Programming", 2345, 40));

    }
}