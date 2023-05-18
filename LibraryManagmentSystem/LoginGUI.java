import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    private String enteredPassword;
    private String enteredID;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(250.0);
        passwordField.setLayoutY(163.0);
        passwordField.setPromptText("Password");

        TextField idField = new TextField();
        idField.setLayoutX(250.0);
        idField.setLayoutY(107.0);
        idField.setPromptText("ID");

        Label loginLabel = new Label("Login Page");
        loginLabel.setLayoutX(247.0);
        loginLabel.setLayoutY(14.0);
        loginLabel.setPrefSize(177.0, 45.0);
        loginLabel.setStyle("-fx-background-color: black;");
        loginLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        loginLabel.setAlignment(javafx.geometry.Pos.CENTER);
        loginLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        loginLabel.setFont(new Font(20.0));
        loginLabel.setEffect(new ColorAdjust());

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(280.0);
        loginButton.setLayoutY(246.0);
        loginButton.setOnAction(event -> {
            enteredPassword = passwordField.getText();
            enteredID = idField.getText();
            // boolean validCredentials = validateCredentials(Integer.parseInt(enteredID), enteredPassword , Library.persons, primaryStage);
            validateCredentials(Integer.parseInt(enteredID), enteredPassword , Library.persons, primaryStage);
        });

        root.getChildren().addAll(passwordField, idField, loginLabel, loginButton);

        Scene scene = new Scene(root, 687, 474);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean validateCredentials(int userID, String password, ArrayList<Person> persons, Stage primaryStage) {
        // Perform your validation logic here
        // For demonstration purposes, assume that the ID is valid if it is a positive integer
        boolean isValidID = false;
        boolean isValidPassword = false; // Replace with your actual validation logic
        for (Person person : persons) {
            if (person.getuser_ID() == userID && person.getPassword().equalsIgnoreCase(password) && person.getIsAdmin()) {
                isValidID = true;
                isValidPassword = true;
                showSuccessAlert(person.getFirstName());
                Stage adminStage = new Stage();
                AdminGUI adminGUI = new AdminGUI(person);
                adminGUI.start(adminStage);
                primaryStage.close();
            }
            else if (person.getuser_ID() == userID && person.getPassword().equalsIgnoreCase(password) && person.getIsAdmin() == false) {
                isValidID = true;
                isValidPassword = true;
                showSuccessAlert(person.getFirstName());
                Stage readerStage = new Stage();
                ReaderGUI readerGUI = new ReaderGUI(person);
                readerGUI.start(readerStage);
                primaryStage.close();
            }
        }

        if (isValidID == false || isValidPassword == false) {
            showErrorAlert(primaryStage);
            Stage loginStage = new Stage();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.start(loginStage);
            primaryStage.close();
            return false;
        } else {
            return true;
        }
    }

    private void showSuccessAlert(String name) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Login Successful");
        alert.setHeaderText(null);
        alert.setContentText("Welcome " + name + " to the Library Management System!");
        alert.showAndWait();
    }

    private void showErrorAlert(Stage primaryStage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText("Invalid credentials. Please enter a valid ID and password.");

        ButtonType logoutButton = new ButtonType("Logout", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().add(logoutButton);

        Button logoutButtonControl = (Button) alert.getDialogPane().lookupButton(logoutButton);
        logoutButtonControl.setOnAction(event -> {
            System.exit(0);
        });

        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
