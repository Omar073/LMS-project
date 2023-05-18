import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DisplayListGUI extends Application {
    private ArrayList<?> list; // ArrayList containing either an array of Persons or an array of Books

    public DisplayListGUI(ArrayList<?> list) {
        this.list = list;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        ListView<String> listView = new ListView<>();

        // Convert the ArrayList to an ObservableList of Strings
        ObservableList<String> items = FXCollections.observableArrayList();

        
        // Add each item in the ArrayList to the ObservableList
        for (Object item : list) {
            if (item instanceof Book) {
                displayBookInfo((Book) item, items);
            } else if (item instanceof Person) {
                displayPersonInfo((Person) item, items);
            }
        }

        // Check if the list is empty
        if (items.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty List");
            alert.setHeaderText(null);
            alert.setContentText("The list is empty.");
            alert.showAndWait();
        }

        // Set the ObservableList as the items of the ListView
        listView.setItems(items);

        root.getChildren().add(listView);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("List Display");
        primaryStage.show();
    }

    private void displayBookInfo(Book book, ObservableList<String> items) {
        String bookInfo = "\nBook Name: " + book.getbook_Title() +
                "\nBook ID: " + book.getBookID() +
                "\nBook Author: " + book.getAuthor() +
                "\nBook Price: " + book.getPrice() +
                "\nBook Quantity: " + book.getQuantity() +
                "\n";
        items.add(bookInfo);
    }

    private void displayPersonInfo(Person person, ObservableList<String> items) {
        String personInfo = "\nFirst Name: " + person.getFirstName() +
                "\nLast Name: " + person.getLastName() +
                "\nPhone Number: " + person.getPhoneNumber() +
                "\nEmail: " + person.getEmail() +
                "\n";
        items.add(personInfo);
    }

    public static void main(String[] args) {
        // Example usage: Displaying an ArrayList of Persons
        DisplayListGUI displayListGUI = new DisplayListGUI(Library.persons);
        displayListGUI.launch(args);

        // Example usage: Displaying an ArrayList of Books
        displayListGUI = new DisplayListGUI(Library.books);
        displayListGUI.launch(args);
    }
}

// import javafx.application.Application;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.scene.Scene;
// import javafx.scene.control.ListView;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
// import java.util.ArrayList;

// public class DisplayListGUI extends Application {
//     private ArrayList<?> list; // ArrayList containing either an array of Persons or an array of Books

//     public DisplayListGUI(ArrayList<?> list) {
//         this.list = list;
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         VBox root = new VBox();
//         ListView<String> listView = new ListView<>();

//         // Convert the ArrayList to an ObservableList of Strings
//         ObservableList<String> items = FXCollections.observableArrayList();

//         // Add each item in the ArrayList to the ObservableList
//         for (Object item : list) {
//             items.add(item.toString());
//         }

//         // Set the ObservableList as the items of the ListView
//         listView.setItems(items);

//         root.getChildren().add(listView);

//         Scene scene = new Scene(root, 400, 300);
//         primaryStage.setScene(scene);
//         primaryStage.setTitle("List Display");
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//         // // Example usage: Displaying an ArrayList of Persons
//         // ArrayList<Person> personList = new ArrayList<>();
//         // personList.add(new Person(1, "password1", true, "John", "Doe", "Male", "123 Street", 123456789, "john@example.com", false));
//         // personList.add(new Person(2, "password2", false, "Jane", "Smith", "Female", "456 Avenue", 987654321, "jane@example.com", false));

//         // DisplayListGUI displayListGUI = new DisplayListGUI(personList);
//         // displayListGUI.launch(args);

//         // // Example usage: Displaying an ArrayList of Books
//         // ArrayList<Book> bookList = new ArrayList<>();
//         // bookList.add(new Book("Book 1", 1, "Author 1", 10, 5));
//         // bookList.add(new Book("Book 2", 2, "Author 2", 15, 8));

//         // DisplayListGUI displayListGUI = new DisplayListGUI(bookList);
//         // displayListGUI.launch(args);
//     }
// }

