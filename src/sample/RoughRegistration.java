package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoughRegistration {
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

    Connection c;
    PreparedStatement Pstatement;
    String URL= "jdbc:mysql://localhost/tutorial";
    String userID="root";
    String passwordID="";

    @FXML
    void register(ActionEvent event) throws SQLException, IOException {
        try {

            String uname = textName.getText().toString();
            String email = textEmail.getText().toString();
            String usersname = textUser.getText().toString();
            String passwords = passfxml.getText().toString();
            System.out.println("eddur hoise"+uname+email+usersname+passwords);

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(URL, userID, passwordID);
            Pstatement= c.prepareStatement("INSERT INTO `user` (`ID`,`name`, `email`, `username`, `password`) VALUES (NULL,?,?,?,?)");

            Pstatement.setString(1,uname);
            Pstatement.setString(2,email);
            Pstatement.setString(3,usersname);
            Pstatement.setString(4,passwords);


            int status = Pstatement.executeUpdate();
            System.out.println(status);
            if(status==1) {
                JOptionPane.showMessageDialog(null, "Record Added");
                System.out.println("Connection Succeeded..........");
                textName.setText("");
                textEmail.setText("");
                textUser.setText("");
                passfxml.setText("");
                textUser.requestFocus();

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Record Failed");
                System.out.println("Failed");
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}

