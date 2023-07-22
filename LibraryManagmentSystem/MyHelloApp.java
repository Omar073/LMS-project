// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.image.Image;
// import javafx.scene.layout.Background;
// import javafx.scene.layout.BackgroundImage;
// import javafx.scene.layout.BackgroundPosition;
// import javafx.scene.layout.BackgroundRepeat;
// import javafx.scene.layout.BackgroundSize;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;

// public class MyHelloApp extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         StackPane root = new StackPane();
//         root.setAlignment(Pos.CENTER);

//         Button loginButton = new Button("Login");
//         loginButton.setOnAction(event -> {
//             Stage loginStage = new Stage();
//             LoginGUI loginGUI = new LoginGUI();
//             loginGUI.start(loginStage);
//             primaryStage.close();
//         });

//         Button signupButton = new Button("Signup");
//         signupButton.setOnAction(event -> {
//             Stage signupStage = new Stage();
//             SignUpGUI signupGUI = new SignUpGUI("signup");
//             signupGUI.start(signupStage);
//             primaryStage.close();
//         });

//         StackPane.setMargin(loginButton, new Insets(0, 0, 90, 0)); // Add margin to separate buttons
//         root.getChildren().addAll(loginButton, signupButton);

//         // Set panel size
//         double panelWidth = 687;
//         double panelHeight = 474;
//         root.setMinSize(panelWidth, panelHeight);
//         root.setMaxSize(panelWidth, panelHeight);
        

//         // Set background image
//         Image backgroundImage = new Image("image.jpg");
//         BackgroundImage background = new BackgroundImage(
//                 backgroundImage,
//                 BackgroundRepeat.NO_REPEAT,
//                 BackgroundRepeat.NO_REPEAT,
//                 BackgroundPosition.CENTER,
//                 new BackgroundSize(panelWidth, panelHeight, false, false, false, false)
//         );
//         root.setBackground(new Background(background));


//         Scene scene = new Scene(root, panelWidth, panelHeight);
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MyHelloApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        Button loginButton = new Button("Login");
        loginButton.setPrefSize(100, 40);
        loginButton.setFont(new Font(20));
        loginButton.setOnAction(event -> {
            Stage loginStage = new Stage();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.start(loginStage);
            primaryStage.close();
        });

        Button signupButton = new Button("Signup");
        signupButton.setPrefSize(100, 40);
        signupButton.setFont(new Font(20));
        signupButton.setOnAction(event -> {
            Stage signupStage = new Stage();
            SignUpGUI signupGUI = new SignUpGUI("signup");
            signupGUI.start(signupStage);
            primaryStage.close();
        });

        Button logoutButton = new Button("Logout");
        logoutButton.setLayoutX(307.0);
        logoutButton.setLayoutY(411.0);
        logoutButton.setPrefSize(100, 40);
        logoutButton.setFont(new Font(20));
        logoutButton.setOnAction(event -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Logged out successfully!");
            alert.showAndWait();
            System.exit(0);
        });

        StackPane buttonPane = new StackPane(loginButton, signupButton, logoutButton);
        buttonPane.setAlignment(Pos.CENTER); // Align buttons to center of StackPane
        buttonPane.setPadding(new Insets(10));
        StackPane.setMargin(loginButton, new Insets(0, 0, 110, 0));
        StackPane.setMargin(logoutButton, new Insets(250, 0, 0, 0));

        root.getChildren().add(buttonPane);

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
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
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
