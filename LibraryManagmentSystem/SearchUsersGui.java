import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SearchUsersGui extends Application {

    private ArrayList<?> list; // ArrayList containing either an array of Persons or an array of Books
    private String Type;
    private String Search_key;
    private String Case;

    public SearchUsersGui(String Type, String Case) {
        // this.list = list;
        this.Type = Type;
        this.Case = Case;
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
        searchButton.setLayoutX(215);
        searchButton.setLayoutY(165);
        searchButton.setPrefSize(74, 34);
        searchButton.setOnAction(event -> {
            Search_key = textField.getText();
            Person person = null;
            boolean isId = true;
            try {
                for (Person p : Library.persons) {
                    if (p.getuser_ID() == Integer.parseInt(Search_key)) {
                        person = p;
                        isId = true;
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
                isId = false;
            }
        
            if (!isId) {
                for (Person p : Library.persons) {
                    if (p.getFirstName().equalsIgnoreCase(Search_key)) {
                        person = p;
                        isId = true;
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

        if(Type.equals("admin") && Case.equals("delete")){
            Button deleteButton = new Button("Delete");
            deleteButton.setLayoutX(364);
            deleteButton.setLayoutY(165);
            deleteButton.setPrefSize(74, 34);
            deleteButton.setOnAction(event -> {
                Search_key = textField.getText();
                boolean isId = true;
                Person person = null;
                try {
                    for (Person p : Library.persons) {
                        if (p.getuser_ID() == Integer.parseInt(Search_key)) {
                            person = p;
                            isId = true;
                            Library.persons.remove(person);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("User Deleted");
                            alert.setHeaderText(null);
                            alert.setContentText("User successfully deleted1");
                            alert.showAndWait();
                        }
                    }
                    if (person == null) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("User not found.");
                        alert.showAndWait();
                    }
                }
                catch (NumberFormatException e) {
                    isId = false;
                }
            
                if (!isId) {
                    for (Person p : Library.persons) {
                        if (p.getFirstName().equalsIgnoreCase(Search_key)) {
                            person = p;
                            Library.persons.remove(person);
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("User Deleted");
                            alert.setHeaderText(null);
                            alert.setContentText("User successfully deleted1");
                            alert.showAndWait();
                        }
                    }
                    if (person == null) {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("User not found.");
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
        // else if(Type.equals("user")){
        //     Button returnButton = new Button("Return");
        //     returnButton.setLayoutX(285);
        //     returnButton.setLayoutY(335);
        //     returnButton.setPrefSize(83, 45);
        //     returnButton.setOnAction(event -> {
        //         //return to user page
        //         // Stage adminStage = new Stage();
        //         // AdminGUI adminGUI = new AdminGUI();
        //         // adminGUI.start(adminStage);
        //         primaryStage.close();
        //     });

        //     root.getChildren().addAll(textField, label, searchButton, returnButton);
        // }
        else if(Type.equals("admin") && Case.equals("block")){

            Button blockButton = new Button("Block");
            blockButton.setLayoutX(364);
            blockButton.setLayoutY(165);
            blockButton.setPrefSize(74, 34);
            blockButton.setOnAction(event -> {
                Search_key = textField.getText();
                try{
                    for(Person p : Library.persons){
                        if(p.getuser_ID() == Integer.parseInt(Search_key)){
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
                    for(Person p : Library.persons){
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

            root.getChildren().addAll(textField, label, searchButton, blockButton, returnButton);
        }

        
        Button returnButton = new Button("Return");
        returnButton.setLayoutX(285);
        returnButton.setLayoutY(335);
        returnButton.setPrefSize(83, 45);
        //add root.get children here so that it would add children before clicking return button
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
        Scene scene = new Scene(root, 687, 474);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Search Books GUI");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
