package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test {
    private Stage stage;
    private Scene scene;
    private Parent root;


    List<VBox> VboxList = new ArrayList<VBox>();

    @FXML
    VBox v1 = new VBox();
    @FXML
    VBox v2 = new VBox();
    @FXML
    VBox v3 = new VBox();
    @FXML
    VBox v4 = new VBox();
    @FXML
    VBox v5 = new VBox();
    @FXML
    VBox v6= new VBox();
    @FXML
    VBox v7= new VBox();
    @FXML
    VBox v8= new VBox();
    @FXML
    VBox v9= new VBox();
    @FXML
    VBox v10= new VBox();

    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogIn(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBookProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BookProfile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void search (ActionEvent event) {
        VboxList.add(v1);
        VboxList.add(v2);
        VboxList.add(v3);
        VboxList.add(v4);
        VboxList.add(v5);
        VboxList.add(v6);
        VboxList.add(v7);
        VboxList.add(v8);
        VboxList.add(v9);
        VboxList.add(v10);

        System.out.println("eddur hoise");

        int count = 0;
        for (VBox vBox : VboxList) {
            InputStream stream = null;
            try {
                stream = new FileInputStream("D:\\Project\\src\\sample\\img.png");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Image image = new Image(stream);
            //Creating the image view
            ImageView imageView = new ImageView();
            //Setting image to the image view
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);

            Label label = new Label("here");
            Label label2 = new Label("2");
            Hyperlink hyperlink = new Hyperlink("hyper");

            vBox.getChildren().addAll(imageView, label, label2, hyperlink);

        }
        count++;

    }
}
