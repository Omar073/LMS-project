import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class DisplayListGUI extends Application {
    private ArrayList<?> list; // ArrayList containing either an array of Persons or an array of Books
    private String type;

    public DisplayListGUI(ArrayList<?> list, String type) {
        this.list = list;
        this.type = type;
    }

    public DisplayListGUI(ArrayList<?> list) {
        this.list = list;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

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

        Button returnButton = new Button("Return");
        returnButton.setLayoutX(285);
        returnButton.setLayoutY(335);
        returnButton.setPrefSize(83, 45);
        //add root.get children here so that it would add children before clicking return button
        returnButton.setOnAction(event -> {
            if(type.equals("admin")){
                Stage adminStage = new Stage();
                AdminGUI adminGUI = new AdminGUI();
                adminGUI.start(adminStage);
                primaryStage.close();
            }
            else if(type.equals("reader")){
                Stage readerStage = new Stage();
                ReaderGUI readerGUI = new ReaderGUI();
                readerGUI.start(readerStage);
                primaryStage.close();
            }
        });

        root.getChildren().addAll(listView, returnButton);

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