package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;

import static sample.AlltheVariables.Nameofuser;
import static sample.AlltheVariables.friend;
import static sample.Searchpage.fbookname;
import static sample.Searchpage.fusername;

public class Fetch implements Initializable {

    public static String users;
    public static String books;
    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection c;
    String URL= "jdbc:mysql://localhost/tutorial";
    String userID="root";
    String passwordID="";

    @FXML
    private Label bname;

    @FXML
    private Label aname;

    @FXML
    private Label ptype;

    @FXML
    private Label bprice;

    @FXML
    private Label sprice;

    @FXML
    private Label location;

    @FXML
    private Label genre;

    @FXML
    private Label contact;

    @FXML
    private ImageView image = new ImageView();

    @FXML
    private Hyperlink hyperlink;


    public void bookinfo() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("eddur");

        hyperlink.setText(users);

        Class.forName("com.mysql.cj.jdbc.Driver");
        c= (Connection) DriverManager.getConnection(URL,userID,passwordID);
        System.out.println("Connection Succeeded..........");

        Statement st= c.createStatement();
        String string = "SELECT * FROM `store` WHERE `username` LIKE '"+users+"' AND `bookname` LIKE '%"+books+"%'";
        System.out.println(string);

        ResultSet result =st.executeQuery(string);
        result.next();

        bname.setText(books);
        aname.setText(result.getString(3));
        ptype.setText(result.getString(4));
        bprice.setText(result.getString(5));
        sprice.setText(result.getString(6));
        location.setText(result.getString(7));
        genre.setText(result.getString(8));
        contact.setText(result.getString(9));

        Blob img = result.getBlob(11);

        InputStream input = img.getBinaryStream();
        if (input != null && input.available() > 1) {

            System.out.println("image available");
            Image imge = new Image(input);
            image.setImage(imge);
        }
    }


    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        try {
            users=fusername;
            AlltheVariables.friend=fusername;
            System.out.println(friend);
            books=fbookname;
            System.out.println(users+" "+ books);
            bookinfo();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        Searchpage.counter=1;
        root = FXMLLoader.load(getClass().getResource("Searchpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void switchtoFriendProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FriendProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}