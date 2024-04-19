import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchUsersGui extends Application {

    // private ArrayList<?> list; // ArrayList containing either an array of Persons or an array of Books
    private String Type;
    private String Search_key;

    public SearchUsersGui(String Type, String Case) {
        this.Type = Type;
    }

    @Override
    public void start(Stage primaryStage) {
        // Pane root = new Pane();
        VBox root = new VBox(10); // VBox with spacing of 10 between elements
        root.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        textField.setLayoutX(252);
        textField.setLayoutY(116);
        textField.setPromptText("User name or ID");

        Label label = new Label("Search Users");
        label.setLayoutX(238);
        label.setLayoutY(27);
        label.setPrefSize(177, 45);
        label.setStyle("-fx-background-color: black;");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font(22));

        Button searchButton = new Button("Search");
        if(Type.equals("admin")){
            searchButton.setLayoutX(215);
            searchButton.setLayoutY(165);
        }
        else if(Type.equals("reader")){
            searchButton.setLayoutX(290);
            searchButton.setLayoutY(165);
        }
        searchButton.setPrefSize(80, 40);
        searchButton.setFont(new Font(18));
        searchButton.setOnAction(event -> {
            Search_key = textField.getText();
            Person person = null;
            // try {
            //     for (Person p : Library.persons) {
            //         if (p.getuser_ID() == Integer.parseInt(Search_key)) {
            //             person = p;
            //             Alert alert = new Alert(AlertType.INFORMATION);
            //             alert.setTitle("Person Information");
            //             alert.setHeaderText(null);
            //             alert.setContentText("First Name: " + p.getFirstName()
            //                     + "\nLast Name: " + p.getLastName()
            //                     + "\nID: " + p.getuser_ID()
            //                     + "\nPhone Number: " + p.getPhoneNumber()
            //                     + "\nEmail: " + p.getEmail());
            //             alert.showAndWait();
            //         }
            //     }
            // }
            try {
                Iterator<Person> iterator = Library.persons.iterator();
                while (iterator.hasNext()) {
                    Person p = iterator.next();
                    if (p.getuser_ID() == Integer.parseInt(Search_key)) {
                        person = p;
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Person Information");
                        alert.setHeaderText(null);
                        alert.setContentText("First Name: " + p.getFirstName()
                                + "\nLast Name: " + p.getLastName()
                                + "\nID: " + p.getuser_ID()
                                + "\nPhone Number: " + p.getPhoneNumber()
                                + "\nEmail: " + p.getEmail());
                        alert.showAndWait();
                    }
                }
            }
            catch (NumberFormatException e) {
                Iterator<Person> iterator = Library.persons.iterator();
                while (iterator.hasNext()) {
                    Person p = iterator.next();
                    if (p.getFirstName().equalsIgnoreCase(Search_key)) {
                        person = p;
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Person Information");
                        alert.setHeaderText(null);
                        alert.setContentText("First Name: " + p.getFirstName()
                                + "\nLast Name: " + p.getLastName()
                                + "\nID: " + p.getuser_ID()
                                + "\nPhone Number: " + p.getPhoneNumber()
                                + "\nEmail: " + p.getEmail());
                        alert.showAndWait();
                    }
                }
            }
            if (person == null) {
                Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("User not found.");
                    alert.showAndWait();
            }
        });

        
        Button deleteButton = new Button("Delete");
        Button blockButton = new Button("Block");
        if(Type.equals("admin")){
            deleteButton.setLayoutX(364);
            deleteButton.setLayoutY(165);
            deleteButton.setPrefSize(80, 40);
            deleteButton.setFont(new Font(18));
            deleteButton.setOnAction(event -> {
                Search_key = textField.getText();
                Person person = null;
                // try {
                //     for (Person p : Library.persons) {
                //         if (p.getuser_ID() == Integer.parseInt(Search_key)) {
                //             person = p;
                //             Library.persons.remove(person);
                //             Alert alert = new Alert(AlertType.INFORMATION);
                //             alert.setTitle("User Deleted");
                //             alert.setHeaderText(null);
                //             alert.setContentText("User successfully deleted");
                //             alert.showAndWait();
                //             // exception error  *************************************************************
                //         }
                //     }
                // }
                try {
                    Iterator<Person> iterator = Library.persons.iterator();
                    while (iterator.hasNext()) {
                        Person p = iterator.next();
                        if (p.getuser_ID() == Integer.parseInt(Search_key)) {
                            person = p;
                            iterator.remove(); // Safely remove the element using the iterator
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("User Deleted");
                            alert.setHeaderText(null);
                            alert.setContentText("User successfully deleted");
                            alert.showAndWait();
                        }
                    }
                }
                catch (NumberFormatException e) {
                    Iterator<Person> iterator = Library.persons.iterator();
                    while (iterator.hasNext()) {
                        Person p = iterator.next();
                        if (p.getFirstName().equalsIgnoreCase(Search_key)) {
                            person = p;
                            iterator.remove(); // Safely remove the element using the iterator
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("User Deleted");
                            alert.setHeaderText(null);
                            alert.setContentText("User successfully deleted");
                            alert.showAndWait();
                        }
                    }
                }

                if (person == null) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("User not found.");
                        alert.showAndWait();
                    }
        
            });

            blockButton.setLayoutX(290);
            blockButton.setLayoutY(210);
            blockButton.setPrefSize(80, 40);
            blockButton.setFont(new Font(18));
            blockButton.setOnAction(event -> {
                Search_key = textField.getText();
                // try{
                //     for(Person p : Library.persons){
                //         if(p.getuser_ID() == Integer.parseInt(Search_key)){
                //             p.setIsBlocked(true);
                //             Alert alert = new Alert(AlertType.INFORMATION);
                //                 alert.setTitle("User Blocked");
                //                 alert.setHeaderText(null);
                //                 alert.setContentText("User successfully blocked");
                //                 alert.showAndWait();
                //         }
                //     }
                // }

                try {
                    Iterator<Person> iterator = Library.persons.iterator();
                    while (iterator.hasNext()) {
                        Person p = iterator.next();
                        if (p.getuser_ID() == Integer.parseInt(Search_key)) {
                            p.setIsBlocked(true);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("User Blocked");
                            alert.setHeaderText(null);
                            alert.setContentText("User successfully blocked");
                            alert.showAndWait();
                        }
                    }
                }
                catch(NumberFormatException e){
                    Iterator<Person> iterator = Library.persons.iterator();
                    while (iterator.hasNext()) {
                        Person p = iterator.next();
                        if(p.getFirstName().equalsIgnoreCase(Search_key)){
                            p.setIsBlocked(true);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("User Blocked");
                            alert.setHeaderText(null);
                            alert.setContentText("User successfully blocked");
                            alert.showAndWait();
                        }
                    }
                }
                
            });

            root.getChildren().addAll(textField, label, searchButton, deleteButton, blockButton);
        }

        if(Type.equals("reader")){
            root.getChildren().addAll(textField, label, searchButton);
        }
        
        Button returnButton = new Button("Back");
        returnButton.setLayoutX(285);
        returnButton.setLayoutY(360);
        returnButton.setPrefSize(100, 40);
        returnButton.setFont(new Font(18));
        //add root.get children here so that it would add children before clicking return button
        returnButton.setOnAction(event -> {
            if(Type.equals("admin")){
                Stage adminStage = new Stage();
                AdminGUI adminGUI = new AdminGUI();
                adminGUI.start(adminStage);
                primaryStage.close();
            }
            else if(Type.equals("reader")){
                Stage readerStage = new Stage();
                ReaderGUI readerGUI = new ReaderGUI();
                readerGUI.start(readerStage);
                primaryStage.close();
            }
        });

        root.getChildren().add(returnButton);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMinSize(500, 300);
        gridPane.setHgap(25);
        gridPane.setVgap(10);
        gridPane.add(label, 0, 0, 2, 1); // col index, row index, col span, row span
        gridPane.add(textField, 0, 1, 2, 1); // col index, row index, col span, row span
        gridPane.add(searchButton, 0, 2, 2, 1); // col index, row index, col span, row span
        gridPane.add(deleteButton, 1, 2, 2, 1); // col index, row index, col span, row span
        gridPane.add(blockButton, 1, 3, 2, 1); // col index, row index, col span, row span
        gridPane.add(returnButton, 0, 18, 2, 1); //  col index, row index, col span, row span
        GridPane.setMargin(label, new Insets(0, 0, 15, 0)); // top, right, bottom, left
        GridPane.setMargin(blockButton, new Insets(3, 0, 0, 25)); // top, right, bottom, left
        GridPane.setMargin(searchButton, new Insets(5, 25, 0, 0)); // top, right, bottom, left
        GridPane.setMargin(deleteButton, new Insets(5, 0, 0, 70)); // top, right, bottom, left
        GridPane.setMargin(returnButton, new Insets(5, 0, 0, 45)); // top, right, bottom, left

        // ?StackPane UserPane = new StackPane();
        // UserPane.setAlignment(Pos.CENTER);
        // UserPane.setPadding(new Insets(10));
        // StackPane.setMargin(textField, new Insets(0, 0, 10, 0)); // top, right, bottom, left
        // StackPane.setMargin(label, new Insets(10, 0, 10, 0)); // top, right, bottom, left
        // StackPane.setMargin(searchButton, new Insets(5, 10, 5, 0)); // top, right, bottom, left
        // if(Type.equals("admin")){
        //     StackPane.setMargin(deleteButton, new Insets(5, 0, 5, 10)); // top, right, bottom, left
        //     StackPane.setMargin(blockButton, new Insets(10, 0, 0, 0)); // top, right, bottom, left
        // }
        // StackPane.setMargin(returnButton, new Insets(10, 0, 0, 0)); // top, right, bottom, left

        //! (textField, label, searchButton, deleteButton, blockButton, returnButton)

        root.getChildren().add(gridPane);

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
        primaryStage.setTitle("Search Users");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
