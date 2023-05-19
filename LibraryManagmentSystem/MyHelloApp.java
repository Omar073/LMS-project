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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyHelloApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            Stage loginStage = new Stage();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.start(loginStage);
            primaryStage.close();
        });

        Button signupButton = new Button("Signup");
        signupButton.setOnAction(event -> {
            Stage signupStage = new Stage();
            SignUpGUI signupGUI = new SignUpGUI("signup");
            signupGUI.start(signupStage);
            primaryStage.close();
        });

        StackPane.setMargin(loginButton, new Insets(0, 0, 90, 0)); // Add margin to separate buttons
        root.getChildren().addAll(loginButton, signupButton);

        // Set panel size
        double panelWidth = 687;
        double panelHeight = 474;
        root.setMinSize(panelWidth, panelHeight);
        root.setMaxSize(panelWidth, panelHeight);
        

        // Set background image
        Image backgroundImage = new Image("image.jpg");
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(panelWidth, panelHeight, false, false, false, false)
        );
        root.setBackground(new Background(background));


        Scene scene = new Scene(root, panelWidth, panelHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
