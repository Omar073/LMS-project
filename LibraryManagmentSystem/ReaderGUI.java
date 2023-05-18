import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReaderGUI extends Application {

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

        Button searchBooksButton = new Button("Search books");
        searchBooksButton.setLayoutX(290.0);
        searchBooksButton.setLayoutY(291.0);

        Button returnBookButton = new Button("Return a book");
        returnBookButton.setLayoutX(72.0);
        returnBookButton.setLayoutY(291.0);

        Button viewCartButton = new Button("View cart");
        viewCartButton.setLayoutX(303.0);
        viewCartButton.setLayoutY(138.0);

        Button rentBookButton = new Button("Rent a book");
        rentBookButton.setLayoutX(499.0);
        rentBookButton.setLayoutY(138.0);

        Button searchUsersButton = new Button("Search users");
        searchUsersButton.setLayoutX(499.0);
        searchUsersButton.setLayoutY(292.0);

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(304.0);
        logoutButton.setLayoutY(399.0);
        logoutButton.setPrefSize(64.0, 35.0);

        root.getChildren().addAll(readerLabel, viewBooksButton, searchBooksButton, returnBookButton, viewCartButton,
                rentBookButton, searchUsersButton, logoutButton);

        Scene scene = new Scene(root, 687, 474);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
