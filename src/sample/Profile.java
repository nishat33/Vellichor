package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static sample.AlltheVariables.*;


public class Profile implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label username;

    @FXML
    private Label ubio;

    @FXML
    private Label l1;

    @FXML
    private Text r11;

    @FXML
    private ImageView i1;

    @FXML
    private Label l2;

    @FXML
    private Text r2;

    @FXML
    private ImageView i2;

    @FXML
    private Label l3;

    @FXML
    private Text r3;

    @FXML
    private ImageView i3;


    @FXML
    private ImageView dp;

    @FXML
            private Button buttonN;
    @FXML
            private Button buttonB;

    Connection c;
    String URL= "jdbc:mysql://localhost/tutorial";
    String userID="root";
    String passwordID="";

    public void setdp() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = (Connection) DriverManager.getConnection(URL, userID, passwordID);
        System.out.println("Connection Succeeded..........");

        Statement st=c.createStatement();
        String string = "SELECT * FROM `user` WHERE `username` LIKE '"+Nameofuser+"'";
        username.setText(Nameofuser);

        System.out.println(string);
        ResultSet resultSet=st.executeQuery(string);
        resultSet.next();
        ubio.setText(resultSet.getString(5));

        Blob im = resultSet.getBlob(6);
        InputStream it = im.getBinaryStream();
        System.out.println(it);
        if (it != null && it.available() > 1) {

            System.out.println("image available, ik available");
            Image imge = new Image(it);
            dp.setImage(imge);
        }
    }


    public void connection() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = (Connection) DriverManager.getConnection(URL, userID, passwordID);
        System.out.println("Connection Succeeded..........");

        Statement st=c.createStatement();
        String string = "SELECT * FROM `user` WHERE `username` LIKE '"+Nameofuser+"'";
        username.setText(Nameofuser);

        System.out.println(string);
        ResultSet resultSet=st.executeQuery(string);
        resultSet.next();
        ubio.setText(resultSet.getString(5));

        //--------------------------------------------------------------
        userblist.removeAll(userblist);
        Statement stmnt = c.createStatement();
        String stng="SELECT * FROM `store` WHERE `username` LIKE '"+Nameofuser+"'";
        System.out.println(stng);

        ResultSet res = stmnt.executeQuery(stng);

        Statement stmnt2 = c.createStatement();
        String string1="SELECT COUNT(*) AS rowcount FROM `store` WHERE `username` LIKE '"+Nameofuser+"'";
        ResultSet r1 = stmnt2.executeQuery(string1);
        r1.next();
        cnt = r1.getInt("rowcount");

        for(int i=0;i<50;i++) {
            Book b = new Book();
            userblist.add(b);
        }

        int p=0;

        for (int i = 0; i <50; i++) {
            res.next();
            String rv=res.getString(10);
            if(rv.length()>1)
            {
                Blob imga = res.getBlob(11);
                InputStream input = imga.getBinaryStream();

                if (input != null && input.available() > 1) {

                    System.out.println("image available");
                    Image imge = new Image(input);
                    userblist.get(p).img = imge;
                }
                userblist.get(p).rview=rv;
                userblist.get(p).bn=res.getString(2);

                p++;
            }
            if(res.isLast())
                break;
        }
        cnt=p;
        System.out.println(p);

        for (int i = 0+b2; i <0+b3; i++)
        {
            Book bk = userblist.get(i);
            System.out.println(bk.bn);
            if (i == b2 + 0) {

                i1.setImage(bk.img);
                l1.setText(bk.bn);
                r11.setText(bk.rview);


            } else if (i == b2 + 1) {

                i2.setImage(bk.img);
                l2.setText(bk.bn);
                r2.setText(bk.rview);


            }
            else if (i == b2 + 2) {

                i3.setImage(bk.img);
                l3.setText(bk.bn);
                r3.setText(bk.rview);
            }
        }
        if(b2==0)
            buttonB.setDisable(true);
        else if(b2>2)
            buttonB.setDisable(false);

        if(b3>cnt)
            buttonN.setDisable(true);
        else if(b3<cnt)
            buttonN.setDisable(false);

    }
    public void next(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        b2 += 3;
        b3 += 3;
        connection();
    }
    public void back(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        b2 -=3;
        b3 -=3;
        connection();
    }

    public void switchToLogIn(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Searchpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEdit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Edit.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSaleProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SaleProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToReview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Review.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            connection();
            username.setText(Nameofuser);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
