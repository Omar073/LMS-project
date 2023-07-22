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

public class NewBook extends Application{
    
    private String action;
    private Book book = new Book();

    //constructor
    public NewBook(String action) {
        this.action = action;
    }

    public NewBook(String action, Book book) {
        this.action = action;
        this.book = book;
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        TextField bookIDField = new TextField();
        bookIDField.setLayoutX(256.0);
        bookIDField.setLayoutY(126.0);
        bookIDField.setPromptText("Book ID");
        
        TextField bookTitleField = new TextField();
        bookTitleField.setLayoutX(256.0);
        bookTitleField.setLayoutY(89.0);
        bookTitleField.setPromptText("Book Title");
        
        // Label titleLabel = new Label("Add New Book");
        Label titleLabel=null;
        if (action.equals("add")) {
            titleLabel = new Label("Add New Book");
        }
        else if(action.equals("update")){
            titleLabel = new Label("Update Book");
        }
        titleLabel.setLayoutX(242.0);
        titleLabel.setLayoutY(14.0);
        titleLabel.setPrefHeight(45.0);
        titleLabel.setPrefWidth(177.0);
        titleLabel.setStyle("-fx-background-color: black;");
        titleLabel.setText("Add New Book");
        titleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        titleLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        titleLabel.setFont(new Font(23.0));
        
        TextField bookAuthorField = new TextField();
        bookAuthorField.setLayoutX(256.0);
        bookAuthorField.setLayoutY(159.0);
        bookAuthorField.setPromptText("Book Author");
        
        TextField bookPriceField = new TextField();
        bookPriceField.setLayoutX(256.0);
        bookPriceField.setLayoutY(200.0);
        bookPriceField.setPromptText("Book Price");
        
        TextField bookQuantityField = new TextField();
        bookQuantityField.setLayoutX(256.0);
        bookQuantityField.setLayoutY(237.0);
        bookQuantityField.setPromptText("Book Quantity");

        // Button addButton = new Button("Add");
        Button addButton;
        if (action.equals("add")) {
            addButton = new Button("Add");
        } else {
            addButton = new Button("Update");
        }
        addButton.setLayoutX(293.0);
        addButton.setLayoutY(286.0);
        addButton.setPrefHeight(34.0);
        addButton.setPrefWidth(74.0);
        addButton.setOnAction(event -> {
            if(action.equals("add")){
                book.setBookID(Integer.parseInt(bookIDField.getText()));
                book.setbook_Title(bookTitleField.getText());
                book.setAuthor(bookAuthorField.getText());
                book.setPrice(Integer.parseInt(bookPriceField.getText()));
                book.setQuantity(Integer.parseInt(bookQuantityField.getText()));
                Library.books.add(book);
            }
            else if(action.equals("update")){
                book.setBookID(Integer.parseInt(bookIDField.getText()));
                book.setbook_Title(bookTitleField.getText());
                book.setAuthor(bookAuthorField.getText());
                book.setPrice(Integer.parseInt(bookPriceField.getText()));
                book.setQuantity(Integer.parseInt(bookQuantityField.getText()));
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("list updated successfully.");
            alert.showAndWait();
            bookIDField.clear();
            bookTitleField.clear();
            bookAuthorField.clear();
            bookPriceField.clear();
            bookQuantityField.clear();
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
        
        root.getChildren().addAll(bookIDField, bookTitleField, titleLabel, addButton, bookAuthorField, bookPriceField, bookQuantityField, returnButton);
        
        // Create a scene and set it on a stage
        Scene scene = new Scene(root, 687, 474);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Search Books GUI");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}