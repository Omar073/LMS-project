import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchBooksGUI extends Application {

    // private ArrayList<?> list; // ArrayList containing either an array of Persons or an array of Books
    private String Type;
    private String Search_key;
    private String Case;
    private Person person = null;

    public SearchBooksGUI(String Type, String Case) {
        // this.list = list;
        this.Type = Type;
        this.Case = Case;
    }

    public SearchBooksGUI(String Type, String Case, Person person) {
        this.Type = Type;
        this.Case = Case;
        this.person = person;
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        TextField textField = new TextField();
        textField.setLayoutX(252);
        textField.setLayoutY(116);
        textField.setPromptText("Book name or ID");

        Label label = new Label("Search Books");
        label.setLayoutX(238);
        label.setLayoutY(27);
        label.setPrefSize(177, 45);
        label.setStyle("-fx-background-color: black;");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font(22));

        Button searchButton = new Button("Search");
        searchButton.setLayoutX(215);
        searchButton.setLayoutY(165);
        searchButton.setPrefSize(74, 34);
        searchButton.setOnAction(event -> {
            Search_key = textField.getText();
            Book book = null;
            boolean isId = true;
            // for(Object item : list){
            //     if(item instanceof Book){
            //         if(((Book) item).getbook_Title().equalsIgnoreCase(Search_key) || ((Book) item).getBookID() == Integer.parseInt(Search_key)){
            //             Book.displayBookInfo((Book) item);
            //         }
            //     }      for (Book b : Library.books) {
            // }
            try {
                int bookId = Integer.parseInt(Search_key);
                for (Book b : Library.books) {
                if (b.getBookID() == bookId) {
                    book = b;
                    isId = true;
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Book Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Book Name: " + book.getbook_Title()
                            + "\nBook ID: " + book.getBookID()
                            + "\nBook Author: " + book.getAuthor()
                            + "\nBook Price: " + book.getPrice()
                            + "\nBook Quantity: " + book.getQuantity());

                    alert.showAndWait();
                    if(Case.equals("search&update")){
                        NewBookGUI newbook = new NewBookGUI("update", book);
                        Stage newbooksstage = new Stage();
                        newbook.start(newbooksstage);
                        primaryStage.close();
                    }
                }
                }
            }
            catch (NumberFormatException e) {
                isId = false;
            }
        
            if (!isId) {
                for (Book b : Library.books) {
                    if (b.getbook_Title().equalsIgnoreCase(Search_key)) {
                        book = b;
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Book Information");
                        alert.setHeaderText(null);
                        alert.setContentText("Book Name: " + book.getbook_Title()
                                + "\nBook ID: " + book.getBookID()
                                + "\nBook Author: " + book.getAuthor()
                                + "\nBook Price: " + book.getPrice()
                                + "\nBook Quantity: " + book.getQuantity());

                        alert.showAndWait();
                        // break;
                    }
                }
            }
        
            if (book == null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Book not found.");
                alert.showAndWait();
            }
        });

        if(Type.equals("admin") && Case.equals("delete")){
            Button deleteButton = new Button("Delete");
            deleteButton.setLayoutX(364);
            deleteButton.setLayoutY(165);
            deleteButton.setPrefSize(74, 34);
            deleteButton.setOnAction(event -> {
                Search_key = textField.getText();
                boolean isId = true;
                Book book = null;
                try {
                    for (Book b : Library.books) {
                        if (b.getBookID() == Integer.parseInt(Search_key)) {
                            book = b;
                            isId = true;
                            Library.books.remove(book);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Book Deleted");
                            alert.setHeaderText(null);
                            alert.setContentText("Book successfully deleted1");
                            alert.showAndWait();
                        }
                    }
                    if (book == null) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Book not found.");
                        alert.showAndWait();
                    }
                }
                catch (NumberFormatException e) {
                    isId = false;
                }
            
                if (!isId) {
                    for (Book b : Library.books) {
                        if (b.getbook_Title().equalsIgnoreCase(Search_key)) {
                            book = b;
                            Library.books.remove(book);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Book Deleted");
                            alert.setHeaderText(null);
                            alert.setContentText("Book successfully deleted2");
                            alert.showAndWait();
                            // break;
                        }
                    }
                    if (book == null) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Book not found.");
                        alert.showAndWait();
                    }
                }
        
            });
        
            
            Button returnButton = new Button("Return");
            returnButton.setLayoutX(285);
            returnButton.setLayoutY(335);
            returnButton.setPrefSize(83, 45);
            returnButton.setOnAction(event -> {
                Stage adminStage = new Stage();
                AdminGUI adminGUI = new AdminGUI();
                adminGUI.start(adminStage);
                primaryStage.close();
            });

            root.getChildren().addAll(textField, label, searchButton, deleteButton, returnButton);
        }
        else if (Case.equals("addtocart")){
            Button addtocartbutton = new Button("Add To Cart");
            addtocartbutton.setLayoutX(364);
            addtocartbutton.setLayoutY(165);
            addtocartbutton.setPrefSize(100, 34);
            addtocartbutton.setOnAction(event -> {
                Search_key = textField.getText();
                boolean isId = true;
                Book book = null;
                try {
                    for (Book b : Library.books) {
                        if (b.getBookID() == Integer.parseInt(Search_key)) {
                            book = b;
                            isId = true;
                            person.book_cart.add(book);
                            book.setQuantity(book.getQuantity() - 1);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Book Found");
                            alert.setHeaderText(null);
                            alert.setContentText("Book successfully rented");
                            alert.showAndWait();
                        }
                    }
                    if (book == null) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Book not found.");
                        alert.showAndWait();
                    }
                }
                catch (NumberFormatException e) {
                    isId = false;
                }
            
                if (!isId) {
                    for (Book b : Library.books) {
                        if (b.getbook_Title().equalsIgnoreCase(Search_key)) {
                            book = b;
                            isId = true;
                            person.book_cart.add(book);
                            book.setQuantity(book.getQuantity() - 1);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Book Found");
                            alert.setHeaderText(null);
                            alert.setContentText("Book successfully rented");
                            alert.showAndWait();
                        }
                    }
                    if (book == null) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Book not found.");
                        alert.showAndWait();
                    }
                }
            });
            Button returnButton = new Button("Return");
            returnButton.setLayoutX(285);
            returnButton.setLayoutY(335);
            returnButton.setPrefSize(83, 45);
            returnButton.setOnAction(event -> {
                if(Type.equals("admin")){
                Stage adminStage = new Stage();
                AdminGUI adminGUI = new AdminGUI();
                adminGUI.start(adminStage);
                primaryStage.close();
                }
                else if(Type.equals("reader")){
                    Stage readerStage = new Stage();
                    ReaderGUI readerGUI = new ReaderGUI(person);
                    readerGUI.start(readerStage);
                    primaryStage.close();
                }
            });
                
            root.getChildren().addAll(textField, label, searchButton, addtocartbutton, returnButton);
        
        }
        else if(Type.equals("user")){
            Button returnButton = new Button("Return");
            returnButton.setLayoutX(285);
            returnButton.setLayoutY(335);
            returnButton.setPrefSize(83, 45);
            returnButton.setOnAction(event -> {
                //return to user page
                // Stage adminStage = new Stage();
                // AdminGUI adminGUI = new AdminGUI();
                // adminGUI.start(adminStage);
                primaryStage.close();
            });

            root.getChildren().addAll(textField, label, searchButton, returnButton);
        }
        Button returnButton = new Button("Return");
        returnButton.setLayoutX(285);
        returnButton.setLayoutY(335);
        returnButton.setPrefSize(83, 45);
        returnButton.setOnAction(event -> {
            if(Type.equals("admin") && Case.equals("search")){
                Stage adminStage = new Stage();
                AdminGUI adminGUI = new AdminGUI();
                adminGUI.start(adminStage);
                primaryStage.close();
            }
            else if(Type.equals("reader") && Case.equals("search")){
                Stage readerStage = new Stage();
                ReaderGUI readerGUI = new ReaderGUI();
                readerGUI.start(readerStage);
                primaryStage.close();
            }
        });

        
        if(Case.equals("search")){
            root.getChildren().addAll(textField, label, searchButton, returnButton);
        }

        // Set background image
        Image backgroundImage = new Image("image.jpg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        root.setBackground(new Background(background));

        Scene scene = new Scene(root, 687, 474);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Search Books");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
