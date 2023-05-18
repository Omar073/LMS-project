import java.util.ArrayList;

public class Library {
    
    // array list of persons
    static ArrayList<Person> persons;
    

    // array list of books
    static ArrayList<Book> books;

    public Library(){

        persons = new ArrayList<Person>();
        
        persons.add(new Librarian("Omar", "Ahmed", "Male", "123 Main St", 1234567890, "myemail1@email.com", 007, "726", true, false));
        persons.add(new Librarian ("Kareem", "Ahmed", "Male", "123 Main St", 4564356, "newemail2@email.com", 465, "358", true, false));
        persons.add(new Librarian ("Youssef", "Mahmoud", "Male", "123 Main St", 472574257, "newemail6@email.com", 645, "866", true, false));
        persons.add(new Librarian ("Mohammed", "Fadel", "Male", "123 Main St", 3756753, "newemail3@email.com", 374, "245", true, false));
        persons.add(new Librarian ("Basel", "Hany", "Male", "123 Main St", 5467456, "newemail4@email.com", 745, "755", true, false));
        persons.add(new Librarian ("Mazen", "Ahmed", "Male", "123 Main St", 245436654, "newemail5@email.com", 345, "323", true, false));
        persons.add(new Librarian ("Ahmed", "Elsheikh", "Male", "123 Main St", 2345623, "newemail7@email.com", 274, "395", true, false));

        persons.add(new Reader("Mohamed", "Ahmed", "Male", "123 Main St", 1234567890, "reader1@mail.com", 2366, "2366"));
        persons.add(new Reader("Marawan", "Saeed", "Male", "123 Main St", 1234567890, "reader2@mail.com", 4562, "243576"));
        persons.add(new Reader("Sara", "Ali", "Male", "123 Main St", 1234567890, "reader3@mail.com", 2345, "2475"));
        persons.add(new Reader( "Ahmed", "Khalid", "Male", "123 Main St", 1234567890, "reader4@mail.com", 2386, "45678"));
        persons.add(new Reader( "Nour", "Hassan", "Female", "123 Main St", 1234567890, "reader5@mail.com", 2346, "4257"));
        persons.add(new Reader("Mona", "Adel", "Female", "123 Main St", 1234567890, "reader6@mail.com", 6789, "12346"));

        books = new ArrayList<>();

        // adding books to the ArrayList
        
        books.add(new Book("Data Structures", 2674, "John Doe", 100, 30));
        books.add(new Book("C++ for Beginners", 2634, "Jim Carrey", 15, 20));
        books.add(new Book("Web Development", 8564, "Kareem Ahmed", 50, 10));
        books.add(new Book("Python Programming", 2345, "Dariel Adams", 40, 50));
        books.add(new Book("OOP in JAVA", 7203, "Omar Ahmed", 200, 5));

        persons.get(3).book_cart.add(books.get(2));
        persons.get(3).book_cart.add(books.get(4));
        persons.get(3).book_cart.add(books.get(3));
        persons.get(2).book_cart.add(books.get(2));
        persons.get(2).book_cart.add(books.get(4));
        persons.get(2).book_cart.add(books.get(3));
        persons.get(0).book_cart.add(books.get(2));
        persons.get(0).book_cart.add(books.get(4));
        persons.get(0).book_cart.add(books.get(3));


    }
}
