import java.util.Iterator;
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

public class SearchUsersGui extends Application {

    // private ArrayList<?> list; // ArrayList containing either an array of Persons or an array of Books
    private String Type;
    private String Search_key;

    public SearchUsersGui(String Type, String Case) {
        this.Type = Type;
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

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
            searchButton.setLayoutX(240);
            searchButton.setLayoutY(165);
        }
        searchButton.setPrefSize(74, 34);
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

        if(Type.equals("admin")){
            Button deleteButton = new Button("Delete");
            deleteButton.setLayoutX(364);
            deleteButton.setLayoutY(165);
            deleteButton.setPrefSize(74, 34);
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

            Button blockButton = new Button("Block");
            blockButton.setLayoutX(290);
            blockButton.setLayoutY(210);
            blockButton.setPrefSize(74, 34);
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
        
        Button returnButton = new Button("Return");
        returnButton.setLayoutX(285);
        returnButton.setLayoutY(360);
        returnButton.setPrefSize(83, 45);
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
        
        // this line cause exception
        // if(Case.equals("search")){
        //     root.getChildren().addAll(textField, label, searchButton, returnButton);
        // } 

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
        primaryStage.setTitle("Search Books GUI");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
