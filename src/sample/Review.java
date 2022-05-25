package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static sample.AlltheVariables.Nameofuser;

public class Review implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField BookName;

    @FXML
    private TextField AuthorName;

    @FXML
    private TextField Bprice;

    @FXML
    private TextField Sprice;

    @FXML
    ComboBox<String> location;


    @FXML
    private TextField genre;

    @FXML
    private TextField contact;

    @FXML
    private RadioButton Button1, Button2, Button3, Button4;

    @FXML
    private TextField review;
    //********************Variable List

    String BName;
    String Aname;
    String Buy;
    String Sell;
    String where;
    String catagory;
    String number;
    String type;
    String Rview;
    String Picture;

    //***********************Variable List
    //Database Connection Blahblah

    Connection c;
    PreparedStatement Pstatement;
    String URL= "jdbc:mysql://localhost/tutorial";
    String userID="root";
    String passwordID="";


    public void BookUploadForm() {
    }

    //Database blahblah

    @FXML
    void Add(ActionEvent event){
        System.out.println("EDDUR HOISE");
        BName=BookName.getText();
        Aname=AuthorName.getText();
        Buy=Bprice.getText();
        Sell=Sprice.getText();
        catagory=genre.getText();
        number=contact.getText();
        where=location.getValue().toString();
        Rview=review.getText();
        System.out.println(Nameofuser);


        if (Button1.isSelected()) {
            type = Button1.getText();
        } else if (Button2.isSelected()) {
            type = Button2.getText();
        } else if (Button3.isSelected()) {
            type = Button3.getText();
        } else if (Button4.isSelected()) {
            type = Button4.getText();
        }

        /*System.out.println(BName);
        System.out.println(Aname);
        System.out.println(Buy);
        System.out.println(Sell);
        System.out.println(catagory);
        System.out.println(number);
        System.out.println(Rview);
        System.out.println(type);
        System.out.println(where);*/

    }

    @FXML
    private ImageView insertimage;

    FileChooser fileChooser = new FileChooser();
    File file;

    @FXML
    void addImage(ActionEvent event) {
        fileChooser.setTitle("Choose an Image");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*jpg","*.gif"));

        file=fileChooser.showOpenDialog(null);
        if(file!=null) {
            insertimage.setImage(new Image(file.toURI().toString()));
            Picture=file.getAbsolutePath();
            System.out.println(Picture);
        }
        else {
            System.out.println("hoynai baal");
            JOptionPane.showMessageDialog(null, "Please Add an Image");
        }

    }

    @FXML
    void addDatabase(ActionEvent event) throws SQLException, FileNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = (Connection) DriverManager.getConnection(URL, userID, passwordID);

            Pstatement= c.prepareStatement("INSERT INTO `store` (`username`, `bookname`, `authorname`, `printtype`, `buyingprice`," +
                    " `sellingprice`, `location`, `genre`, `contact`, `review`, `image`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            Pstatement.setString(1,Nameofuser);
            Pstatement.setString(2,BName);
            Pstatement.setString(3,Aname);
            Pstatement.setString(4,type);
            Pstatement.setString(5,Buy);
            Pstatement.setString(6,Sell);
            Pstatement.setString(7,where);
            Pstatement.setString(8,catagory);
            Pstatement.setString(9,number);
            Pstatement.setString(10, Rview);

            InputStream is= new FileInputStream(new File(Picture));
            Pstatement.setBlob(11, is);
            int status = Pstatement.executeUpdate();
            System.out.println(status);
            if(status == 1) {
                JOptionPane.showMessageDialog(null, "Record Added");
                System.out.println("Connection Succeeded..........");
            }
            else
            {
                System.out.println("Connection Failed");
            }

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToSaleProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SaleProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list= FXCollections.observableArrayList("Sundarban Courier Service", "S.A. Paribahan", "RedEx","FedEx");
        location.setItems(list);
    }
}
