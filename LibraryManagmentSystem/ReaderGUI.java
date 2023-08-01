import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReaderGUI extends Application {

    static private Person person = null;

    //constructor
    public ReaderGUI(Person person) {
        this.person = person;
    }   

    // default constructor
    public ReaderGUI() {}


    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Label readerLabel = new Label("Reader Page");
        readerLabel.setLayoutX(247.0);
        readerLabel.setLayoutY(14.0);
        readerLabel.setPrefSize(177.0, 45.0);
        readerLabel.setStyle("-fx-background-color: black;");
        readerLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        readerLabel.setAlignment(javafx.geometry.Pos.CENTER);
        readerLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        readerLabel.setFont(new Font(20.0));
        readerLabel.setEffect(new ColorAdjust());

        Button viewBooksButton = new Button("View all books");
        viewBooksButton.setLayoutX(72.0);
        viewBooksButton.setLayoutY(138.0);
        viewBooksButton.setOnAction(event -> {
            DisplayListGUI displayListGUI = new DisplayListGUI(Library.books, "reader");
            Stage displaybooksstage = new Stage();
            displayListGUI.start(displaybooksstage);
            primaryStage.close();
        });

        Button searchBooksButton = new Button("Search books");
        searchBooksButton.setLayoutX(290.0);
        searchBooksButton.setLayoutY(291.0);
        searchBooksButton.setOnAction(event -> {
            SearchBooksGUI searchbooksGUI = new SearchBooksGUI("reader", "search");
            Stage searchbooksstage = new Stage();
            searchbooksGUI.start(searchbooksstage);
            primaryStage.close();
        });

        // Button returnBookButton = new Button("Return a book");
        // returnBookButton.setLayoutX(72.0);
        // returnBookButton.setLayoutY(291.0);

        Button viewCartButton = new Button("View cart");
        viewCartButton.setLayoutX(303.0);
        viewCartButton.setLayoutY(138.0);
        viewCartButton.setOnAction(event -> {
            DisplayListGUI displayListGUI = new DisplayListGUI(person.book_cart, "reader");
            Stage displayListStage = new Stage();
            displayListGUI.start(displayListStage);
            primaryStage.close();
        });

        Button rentBookButton = new Button("Rent a book");
        rentBookButton.setLayoutX(499.0);
        rentBookButton.setLayoutY(138.0);
        rentBookButton.setOnAction(event -> {
            SearchBooksGUI searchbooksGUI = new SearchBooksGUI("reader", "addtocart", person);
            Stage searchbooksstage = new Stage();
            searchbooksGUI.start(searchbooksstage);
            primaryStage.close();
        });

        Button searchUsersButton = new Button("Search users");
        searchUsersButton.setLayoutX(499.0);
        searchUsersButton.setLayoutY(292.0);
        searchUsersButton.setOnAction(event -> {
            SearchUsersGui searchusersGUI = new SearchUsersGui("reader", "search");
            Stage searchusersstage = new Stage();
            searchusersGUI.start(searchusersstage);
            primaryStage.close();
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(304.0);
        logoutButton.setLayoutY(399.0);
        logoutButton.setPrefSize(64.0, 35.0);
        logoutButton.setOnAction(event -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            // alert.setContentText("Welcome to the Library Management System!");
            alert.setContentText("Logged out successfully!");
            alert.showAndWait();
            // System.exit(0);
            HomePage homepage = new HomePage();
            Stage homePageStage = new Stage();
            homepage.start(homePageStage);
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

        root.getChildren().addAll(readerLabel, viewBooksButton, searchBooksButton, viewCartButton,
                rentBookButton, searchUsersButton, logoutButton);

        Scene scene = new Scene(root, 687, 474);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Reader Page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
