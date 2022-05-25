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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static sample.AlltheVariables.*;


public class FriendSale implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection c;
    String URL = "jdbc:mysql://localhost/tutorial";
    String userID = "root";
    String passwordID = "";
    int var = 0;
    static int counter = 0;
    static int cntr = 0;
    static int delete;
    @FXML
    private ImageView dp;

    @FXML
    private Label uname;

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
    private Button button;

    public void connection() throws ClassNotFoundException, SQLException, IOException {
        userbooklist.removeAll(userbooklist);
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = (Connection) DriverManager.getConnection(URL, userID, passwordID);
        System.out.println("Connection Succeeded..........");
        //--------------------



        userbooklist.removeAll(userbooklist);
        Statement st = c.createStatement();
        String string="SELECT * FROM `store` WHERE `username` LIKE '"+friend+"'";
        System.out.println(string);
        ResultSet res = st.executeQuery(string);
        res.next();

        Blob im = res.getBlob(11);
        InputStream it = im.getBinaryStream();

        if (it != null && it.available() > 1) {

            System.out.println("image available");
            Image imge = new Image(it);
            dp.setImage(imge);
        }

        Statement s = c.createStatement();
        String string1="SELECT COUNT(*) AS rowcount FROM `store` WHERE `username` LIKE '"+friend+"'";
        ResultSet r1 = s.executeQuery(string1);
        r1.next();
        cnt = r1.getInt("rowcount");

        for(int i=0;i<50;i++) {
            Book b = new Book();
            userbooklist.add(b);
        }

        for (int i = 0; i <cnt; i++)
        {
            ;
            Blob imga = res.getBlob(11);
            InputStream input = imga.getBinaryStream();

            if (input != null && input.available() > 1) {

                System.out.println("image available");
                Image imge = new Image(input);
                userbooklist.get(i).img=imge;
            }
            userbooklist.get(i).username=res.getString(1);
            userbooklist.get(i).bn= res.getString(2);
            userbooklist.get(i).price = res.getString(6);
            userbooklist.get(i).id=res.getInt(12);
            userbooklist.get(i).hplink= "Click Here";
            res.next();
        }
        for (int i = 0+a2; i <0+a3; i++)
        {
            System.out.println(i);
            Book bk = userbooklist.get(i);

            if (i == a2+0 ) {

                i1.setImage(bk.img);
                l1.setText(bk.bn);
                l2.setText(bk.price);
                h1.setText(bk.hplink);
            }
            else if (i ==a2+1 ) {

                i2.setImage(bk.img);
                l3.setText(bk.bn);
                l4.setText(bk.price);
                h2.setText(bk.hplink);

            } else if (i ==a2+2 ) {

                i3.setImage(bk.img);
                l5.setText(bk.bn);
                l6.setText(bk.price);
                h3.setText(bk.hplink);

            } else if (i ==a2+3 ) {

                i4.setImage(bk.img);
                l7.setText(bk.bn);
                l8.setText(bk.price);

            } else if (i ==a2+4 ) {

                i5.setImage(bk.img);
                l9.setText(bk.bn);
                l10.setText(bk.price);

            }
            else if (i ==a2+5 ) {

                i6.setImage(bk.img);
                l11.setText(bk.bn);
                l12.setText(bk.price);

            } else if (i ==a2+6 ) {

                i7.setImage(bk.img);
                l13.setText(bk.bn);
                l14.setText(bk.price);

            } else if (i ==a2+7 ) {

                i8.setImage(bk.img);
                l15.setText(bk.bn);
                l16.setText(bk.price);

            } else if (i ==a2+8 ) {

                i9.setImage(bk.img);
                l17.setText(bk.bn);
                l18.setText(bk.price);

            } else if (i ==a2+9 ) {

                i10.setImage(bk.img);
                l19.setText(bk.bn);
                l20.setText(bk.price);
            }

        }
    }
    public void next(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        a2 += 10;
        a3 += 10;
        System.out.println(a2 + " " + a3);
        connection();
    }
    public void back(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        a2 -=10;
        a3 -=10;

        System.out.println(a2);
        System.out.println(a3);
        connection();
    }
    @FXML
    void page1(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();
        Fetch.users=userbooklist.get(0+var).username;
        Fetch.books=userbooklist.get(0+var).bn;
        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        connection();

    }
    @FXML
    void page2(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();
        Fetch.users=userbooklist.get(1+var).username;
        Fetch.books=userbooklist.get(1+var).bn;
        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        connection();

    }
    @FXML
    void page3(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();
        Fetch.users=userbooklist.get(2+var).username;
        Fetch.books=userbooklist.get(2+var).bn;
        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        connection();

    }
    public void switchToLogIn(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToFriendProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FriendProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            uname.setText(friend);
            connection();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Searchpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
