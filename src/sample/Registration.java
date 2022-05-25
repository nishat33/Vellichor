package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Registration {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textName;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textUser;

    @FXML
    private PasswordField passfxml;

    @FXML
    private TextField textBio;


    Connection c;
    PreparedStatement Pstatement;
    String URL= "jdbc:mysql://localhost/tutorial";
    String userID="root";
    String passwordID="";


    public String string=null;

    @FXML
    private Button button;

    @FXML
    private ImageView insertimage;

    FileChooser fileChooser = new FileChooser();
    File file;
    @FXML
    void add(ActionEvent event) throws IOException {

        fileChooser.setTitle("Choose an Image");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*jpg","*.gif"));

        file=fileChooser.showOpenDialog(null);
        if(file!=null) {
            insertimage.setImage(new Image(file.toURI().toString()));
            string=file.getAbsolutePath();
            System.out.println(string);
        }
        else {
            System.out.println("hoynai baal");
            JOptionPane.showMessageDialog(null, "Please Add an Image");
        }

    }
    static String usersname;
    @FXML
    void switchtoHomePage(ActionEvent event) throws SQLException, IOException {
        try {
            String uname = "";
            String email = "";

            String passwords = "";
            String bio = "";
            uname = textName.getText().toString();

            email = textEmail.getText().toString();
            usersname = textUser.getText().toString();
            passwords = passfxml.getText().toString();
            bio = textBio.getText().toString();

            AlltheVariables.Nameofuser=usersname;

                System.out.println("eddur hoise" + uname + email + usersname + passwords + bio + string);

                Class.forName("com.mysql.cj.jdbc.Driver");
                c = (Connection) DriverManager.getConnection(URL, userID, passwordID);


                Pstatement = c.prepareStatement("INSERT INTO `user` (`name`, `email`, `username`, `password`,`Bio`,`image`) VALUES (?,?,?,?,?,?)");

                Pstatement.setString(1, uname);
                Pstatement.setString(2, email);
                Pstatement.setString(3, usersname);
                Pstatement.setString(4, passwords);
                Pstatement.setString(5, bio);


                InputStream is = new FileInputStream (new File(string));
                Pstatement.setBlob(6, is);

                Statement st = c.createStatement();
                String exist = null;
                ResultSet result = st.executeQuery("SELECT * FROM `user` WHERE `username` LIKE " + "'" + usersname + "'");
                result.next();
                System.out.println(result);
                int status = 0;
                if(uname.isEmpty()||email.isEmpty()||usersname.isEmpty()||passwords.isEmpty())
                {
                   // JOptionPane.showMessageDialog(null,"Fill up all the fields");
                    System.out.println("whyyyyyyyyyyyy");
                }
                else{

                    status = Pstatement.executeUpdate();
                    System.out.println(status);
                }
                if (status == 1) {
                    JOptionPane.showMessageDialog(null, "Record Added");
                    System.out.println("Connection Succeeded..........");
                    textName.setText("");
                    textEmail.setText("");
                    textUser.setText("");
                    passfxml.setText("");
                    textBio.setText("");
                    textUser.requestFocus();

                    root = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Fill all the records");
                    System.out.println("Failed");
                }

        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Username Already Exists");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void switchToLogIn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}