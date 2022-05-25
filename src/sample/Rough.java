package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

import static sample.AlltheVariables.Nameofuser;

public class Rough {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection c;
    String URL= "jdbc:mysql://localhost/tutorial";
    String userID="root";
    String passwordID="";

    public TextField user;
    public PasswordField password;

    public void button(ActionEvent event) throws SQLException, IOException {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= (Connection) DriverManager.getConnection(URL, userID, passwordID);
            System.out.println("Connection Succeeded..........");
            Statement st= c.createStatement();

            String st1= (String)user.getText().toString();
            String st2= (String)password.getText().toString();

            System.out.println(st1);
            String string = "SELECT * FROM `user` WHERE `username` LIKE "+ "'"+st1+"'";
            System.out.println(string);
            ResultSet result =st.executeQuery(string);
            result.next();


            String id = null, pass = null;

            id=result.getString(3);
            pass=result.getString(4);
            System.out.println("Eddur hoise");
            System.out.println(id);
            System.out.println(id+","+pass);

            System.out.println(st1);
            System.out.println(st2);

            if(st2.equals(pass)){
                root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Nameofuser=st1;
                System.out.println(Nameofuser);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Password");
            }

            c.close();

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Wrong Username or Password");
            System.out.println("Connection Failed............");
        }
    }

}
