package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.AlltheVariables.booklist;
import static sample.Searchpage.fusername;
import static sample.Searchpage.fbookname;

public class Search2 implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    int a2=10;
    int a3=18;
    @FXML
    private VBox main;

    @FXML
    private HBox H1;

    @FXML
    private VBox v1;

    @FXML
    private ImageView i1;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Hyperlink h1;

    @FXML
    private VBox v2;

    @FXML
    private ImageView i2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Hyperlink h2;

    @FXML
    private VBox v3;

    @FXML
    private ImageView i3;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private Hyperlink h3;

    @FXML
    private VBox v4;

    @FXML
    private ImageView i4;

    @FXML
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private Hyperlink h4;

    @FXML
    private VBox v5;

    @FXML
    private ImageView i5;

    @FXML
    private Label l9;

    @FXML
    private Label l10;

    @FXML
    private Hyperlink h5;

    @FXML
    private HBox H2;

    @FXML
    private VBox v6;

    @FXML
    private ImageView i6;

    @FXML
    private Label l11;

    @FXML
    private Label l12;

    @FXML
    private Hyperlink h6;

    @FXML
    private VBox v7;

    @FXML
    private ImageView i7;

    @FXML
    private Label l13;

    @FXML
    private Label l14;

    @FXML
    private Hyperlink h7;

    @FXML
    private VBox v8;

    @FXML
    private ImageView i8;

    @FXML
    private Label l15;

    @FXML
    private Label l16;

    @FXML
    private Hyperlink h8;

    @FXML
    private VBox v9;

    @FXML
    private ImageView i9;

    @FXML
    private Label l17;

    @FXML
    private Label l18;

    @FXML
    private Hyperlink h9;

    @FXML
    private VBox v10;

    @FXML
    private ImageView i10;

    @FXML
    private Label l19;

    @FXML
    private Label l20;

    @FXML
    private Hyperlink h10;

    @FXML
    private Button bleh;

    @FXML
    private Button button;

    @FXML
    private TextField searchbar;


    @FXML
    public void Show(){
        for (int i = 0+ a2; i < 10 + a3; i++) {
            Book bk = booklist.get(i);
            if (i == 0) {

                i1.setImage(bk.img);
                l1.setText(bk.bn);
                l2.setText(bk.price);
                h1.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
                System.out.println(fusername+" "+fbookname);
            } else if (i == 1) {

                i2.setImage(bk.img);
                l3.setText(bk.bn);
                l4.setText(bk.price);
                h2.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 2) {

                i3.setImage(bk.img);
                l5.setText(bk.bn);
                l6.setText(bk.price);
                h3.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 3) {

                i4.setImage(bk.img);
                l7.setText(bk.bn);
                l8.setText(bk.price);
                h4.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 4) {

                i5.setImage(bk.img);
                l9.setText(bk.bn);
                l10.setText(bk.price);
                h5.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 5) {

                i6.setImage(bk.img);
                l11.setText(bk.bn);
                l12.setText(bk.price);
                h6.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 6) {

                i7.setImage(bk.img);
                l13.setText(bk.bn);
                l14.setText(bk.price);
                h7.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 7) {

                i8.setImage(bk.img);
                l15.setText(bk.bn);
                l16.setText(bk.price);
                h8.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 8) {

                i9.setImage(bk.img);
                l17.setText(bk.bn);
                l18.setText(bk.price);
                h9.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            } else if (i == 9) {

                i10.setImage(bk.img);
                l19.setText(bk.bn);
                l20.setText(bk.price);
                h10.setText("click here");
                fusername = bk.username;
                fbookname = bk.bn;
            }
        }

    }
    public void page(ActionEvent event) throws IOException {
        Fetch.books=fbookname;
        Fetch.users=fusername;
        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Show();
    }


}
