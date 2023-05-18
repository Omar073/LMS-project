// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.Pane;
// import javafx.stage.Stage;

// public class MyHelloApp extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         Pane root = new Pane();

//         Button loginButton = new Button("Login");
//         loginButton.setLayoutX(303.0);
//         loginButton.setLayoutY(91.0);
//         loginButton.setOnAction(event -> {
//             Stage loginStage = new Stage();
//             LoginGUI loginGUI = new LoginGUI();
//             loginGUI.start(loginStage);
//             primaryStage.close();
//         });

//         Button signupButton = new Button("Signup");
//         signupButton.setLayoutX(303.0);
//         signupButton.setLayoutY(163.0);
//         signupButton.setOnAction(event -> SignUpPage.SignUp());

//         PasswordField passwordField = new PasswordField();
//         passwordField.setLayoutX(229.0);
//         passwordField.setLayoutY(292.0);
//         passwordField.setPromptText("password");

//         TextField idField = new TextField();
//         idField.setLayoutX(229.0);
//         idField.setLayoutY(225.0);
//         idField.setPromptText("ID");

//         root.getChildren().addAll(loginButton, signupButton, passwordField, idField);

//         Scene scene = new Scene(root, 687, 474);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyHelloApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            Stage loginStage = new Stage();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.start(loginStage);
            primaryStage.close();
        });

        Button signupButton = new Button("Signup");
        signupButton.setOnAction(event -> SignUpPage.SignUp());

        // PasswordField passwordField = new PasswordField();
        // passwordField.setPromptText("Password");

        // TextField idField = new TextField();
        // idField.setPromptText("ID");

        // root.getChildren().addAll(loginButton, signupButton, passwordField, idField);
        root.getChildren().addAll(loginButton, signupButton);

        Scene scene = new Scene(root, 687, 474);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
