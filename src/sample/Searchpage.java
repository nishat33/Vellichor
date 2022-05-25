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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ResourceBundle;

import static sample.AlltheVariables.*;


public class Searchpage implements Initializable {
    static String fusername;
    static String fbookname;
    int var=0;
    static int counter =0;
    static int cntr=1;
    @FXML
    private Hyperlink h1;

    @FXML
    private ImageView i1;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private ImageView i2 ;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Hyperlink h2;

    @FXML
    private ImageView i3 ;

    @FXML
    private Label l5;

    @FXML
    private Label l6;

    @FXML
    private Hyperlink h3;

    @FXML
    private ImageView i4 ;


    @FXML
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private Hyperlink h4;

    @FXML
    private ImageView i5;
    ;

    @FXML
    private Label l9;

    @FXML
    private Label l10;

    @FXML
    private Hyperlink h5;



    @FXML
    private ImageView i6;
    ;

    @FXML
    private Label l11;

    @FXML
    private Label l12;

    @FXML
    private Hyperlink h6;

    @FXML
    private ImageView i7 ;
    ;

    @FXML
    private Label l13;

    @FXML
    private Label l14;

    @FXML
    private Hyperlink h7;


    @FXML
    private ImageView i8 ;

    @FXML
    private Label l15;

    @FXML
    private Label l16;

    @FXML
    private Hyperlink h8;


    @FXML
    private ImageView i9 ;

    @FXML
    private Label l17;

    @FXML
    private Label l18;

    @FXML
    private Hyperlink h9;

    @FXML
    private ImageView i10 ;


    @FXML
    private Label l19;

    @FXML
    private Label l20;

    @FXML
    private Hyperlink h10;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Connection c;
    String URL = "jdbc:mysql://localhost/tutorial";
    String userID = "root";
    String passwordID = "";

    @FXML
    private Button buttonB;
    @FXML
    private Button buttonN;
    @FXML
    private TextField searchbar;


    @FXML
    private ComboBox<String> pick;
    @FXML
    private ComboBox<String> pick1;
    int AlltheVariables;


    String gquery="null";
    String gquery2="null";
    static String criteria;
    static String srch;
    int n2=0;
    int n3=10;

    String smt;
    public void getQuery() throws SQLException, IOException, ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        c = (Connection) DriverManager.getConnection(URL, userID, passwordID);
        System.out.println("Connection Succeeded..........");

            if (counter == 0)
            {
                criteria = pick.getValue().toString();
                if(criteria.equals("all result"))
                {
                    gquery2 = "SELECT * FROM `store` WHERE 1";
                    smt="SELECT COUNT(*) AS rowcount FROM `store` WHERE 1";
                }
                else
                {
                    if (criteria.equals("genre"))
                        srch = pick1.getValue().toString();
                    else
                        srch = searchbar.getText();
                    gquery2 = "SELECT * FROM `store` WHERE `" + criteria + "` LIKE '%" + srch + "%'";
                    smt = "SELECT COUNT(*) AS rowcount FROM `store` WHERE `" + criteria + "` LIKE '%" + srch + "%'";
                }

            }

            System.out.println(smt);

                if(gquery2.equals(gquery)) {
                    System.out.println( "this is " +gquery2);
                    System.out.println("this is " +gquery);
                }
                else
                {
                    n2=0;
                    n3=10;
                }
        gquery = gquery2;
        System.out.println(n2);
        System.out.println(n3);
        bck = gquery;
            //System.out.println(gquery);
            Statement st = c.createStatement();

            ResultSet result = st.executeQuery(gquery);

            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(smt);
            r.next();

            cnt = r.getInt("rowcount");
            r.close();
            System.out.println(c);


        for(int i=0;i<50;i++) {
            Book b = new Book();
            booklist.add(b);
        }

        for (int i = 0; i < cnt; i++) {
            result.next();

                Book b = new Book();
                Blob imga = result.getBlob(11);
                InputStream input = imga.getBinaryStream();

                if (input != null && input.available() > 1) {

                    System.out.println("image available");
                    Image imge = new Image(input);
                    booklist.get(i).img = imge;
                }

                booklist.get(i).username = result.getString(1);

                booklist.get(i).bn = result.getString(2);
                booklist.get(i).price = result.getString(6);
                booklist.get(i).hplink = "click here";
            }


    }

    @FXML
    public void search() throws SQLException, ClassNotFoundException, IOException {
        booklist.removeAll(booklist);
        getQuery();
        System.out.println(n2+" "+n3);
        for (int i = 0+n2; i <0+n3; i++)
        {
            System.out.println(i);
            Book bk = booklist.get(i);

            if (i == n2+0 ) {

                i1.setImage(bk.img);
                l1.setText(bk.bn);
                l2.setText(bk.price);

                h1.setText(bk.hplink);


            }
            else if (i ==n2+1 ) {

                i2.setImage(bk.img);
                l3.setText(bk.bn);
                l4.setText(bk.price);
                h2.setText(bk.hplink);


            } else if (i ==n2+2 ) {

                i3.setImage(bk.img);
                l5.setText(bk.bn);
                l6.setText(bk.price);
                h3.setText(bk.hplink);

            } else if (i ==n2+3 ) {

                i4.setImage(bk.img);
                l7.setText(bk.bn);
                l8.setText(bk.price);
                h4.setText(bk.hplink);

            } else if (i ==n2+4 ) {

                i5.setImage(bk.img);
                l9.setText(bk.bn);
                l10.setText(bk.price);
                h5.setText(bk.hplink);

            }
            else if (i ==n2+5 ) {

                i6.setImage(bk.img);
                l11.setText(bk.bn);
                l12.setText(bk.price);
                h6.setText(bk.hplink);

            } else if (i ==n2+6 ) {

                i7.setImage(bk.img);
                l13.setText(bk.bn);
                l14.setText(bk.price);
                h7.setText(bk.hplink);

            } else if (i ==n2+7 ) {

                i8.setImage(bk.img);
                l15.setText(bk.bn);
                l16.setText(bk.price);
                h8.setText(bk.hplink);;

            } else if (i ==n2+8 ) {

                i9.setImage(bk.img);
                l17.setText(bk.bn);
                l18.setText(bk.price);
                h9.setText(bk.hplink);

            } else if (i ==n2+9 ) {

                i10.setImage(bk.img);
                l19.setText(bk.bn);
                l20.setText(bk.price);
                h10.setText(bk.hplink);
            }

        }
        if(n2==0)
            buttonB.setDisable(true);
        else if(n2>9)
            buttonB.setDisable(false);

        if(n3>cnt)
            buttonN.setDisable(true);
        else if(n3<cnt)
            buttonN.setDisable(false);

    }
    public void next(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        n2 += 10;
        n3 += 10;
        var+=10;
        System.out.println(n2);
        System.out.println(n3);
        search();
    }
    public void back(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        n2 -=10;
        n3 -=10;
        var-=10;
            search();

    }
    public void page1(ActionEvent event) throws IOException {

        fusername=booklist.get(0+var).username;
        fbookname=booklist.get(0+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page2(ActionEvent event) throws IOException {

        fusername=booklist.get(1+var).username;
        fbookname=booklist.get(1+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page3(ActionEvent event) throws IOException {

        fusername=booklist.get(2+var).username;
        fbookname=booklist.get(2+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page4(ActionEvent event) throws IOException {

        fusername=booklist.get(3+var).username;
        fbookname=booklist.get(3+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page5(ActionEvent event) throws IOException {

        fusername=booklist.get(4+var).username;
        fbookname=booklist.get(4+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page6(ActionEvent event) throws IOException {

        fusername=booklist.get(5+var).username;
        fbookname=booklist.get(5+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page7(ActionEvent event) throws IOException {

        fusername=booklist.get(6+var).username;
        fbookname=booklist.get(6+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page8(ActionEvent event) throws IOException {

        fusername=booklist.get(7+var).username;
        fbookname=booklist.get(7+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page9(ActionEvent event) throws IOException {

        fusername=booklist.get(8+var).username;
        fbookname=booklist.get(8+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void page10(ActionEvent event) throws IOException {

        fusername=booklist.get(9+var).username;
        fbookname=booklist.get(9+var).bn;

        root = FXMLLoader.load(getClass().getResource("Fetch.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void backsearch() throws SQLException, IOException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        c = (Connection) DriverManager.getConnection(URL, userID, passwordID);
        System.out.println("Connection Succeeded..........");
        booklist.removeAll(booklist);
        Statement st = c.createStatement();
        System.out.println(bck);
        ResultSet result = st.executeQuery(bck);

        Statement s = c.createStatement();
        String smt="SELECT COUNT(*) AS rowcount FROM `store` WHERE `"+criteria+"` LIKE '%" + srch+ "%'";
        System.out.println(smt);
        ResultSet r = s.executeQuery( smt);
        r.next();
        cnt = r.getInt("rowcount");
        r.close();
        //System.out.println(c);

        for(int i=0;i<50;i++) {
            Book b = new Book();
            booklist.add(b);
        }

        for (int i = 0; i < cnt; i++) {
            result.next();
            Blob imga = result.getBlob(11);
            InputStream input = imga.getBinaryStream();

            if (input != null && input.available() > 1) {

                System.out.println("image available");
                Image imge = new Image(input);
                booklist.get(i).img=imge;
            }
            booklist.get(i).username=result.getString(1);
            booklist.get(i).bn= result.getString(2);
            booklist.get(i).price = result.getString(6);
            booklist.get(i).hplink= "click here";

        }
        for (int i = 0+n2; i <0+n3; i++)
        {
            System.out.println(i);
            Book bk = booklist.get(i);

            if (i == n2+0 ) {

                i1.setImage(bk.img);
                l1.setText(bk.bn);
                l2.setText(bk.price);
                h1.setText(bk.hplink);


            }
            else if (i ==n2+1 ) {

                i2.setImage(bk.img);
                l3.setText(bk.bn);
                l4.setText(bk.price);
                h2.setText(bk.hplink);


            } else if (i ==n2+2 ) {

                i3.setImage(bk.img);
                l5.setText(bk.bn);
                l6.setText(bk.price);
                h3.setText(bk.hplink);

            } else if (i ==n2+3 ) {

                i4.setImage(bk.img);
                l7.setText(bk.bn);
                l8.setText(bk.price);
                h4.setText(bk.hplink);

            } else if (i ==n2+4 ) {

                i5.setImage(bk.img);
                l9.setText(bk.bn);
                l10.setText(bk.price);
                h5.setText(bk.hplink);

            }
            else if (i ==n2+5 ) {

                i6.setImage(bk.img);
                l11.setText(bk.bn);
                l12.setText(bk.price);
                h6.setText(bk.hplink);

            } else if (i ==n2+6 ) {

                i7.setImage(bk.img);
                l13.setText(bk.bn);
                l14.setText(bk.price);
                h7.setText(bk.hplink);

            } else if (i ==n2+7 ) {

                i8.setImage(bk.img);
                l15.setText(bk.bn);
                l16.setText(bk.price);
                h8.setText(bk.hplink);;

            } else if (i ==n2+8 ) {

                i9.setImage(bk.img);
                l17.setText(bk.bn);
                l18.setText(bk.price);
                h9.setText(bk.hplink);

            } else if (i ==n2+9 ) {

                i10.setImage(bk.img);
                l19.setText(bk.bn);
                l20.setText(bk.price);
                h10.setText(bk.hplink);
            }

            System.out.println(fusername);
            System.out.println(fbookname);

        }

    }


    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        try {
            //fixed();

            if(counter>0) {

                backsearch();
            }
            ObservableList<String> list= FXCollections.observableArrayList("genre","authorname","bookname","location","all results");
            pick.setItems(list);
            pick.setValue("all result");
            ObservableList<String> list1= FXCollections.observableArrayList("Fiction","Adventure","Fantasy","Classic"
            ,"Mythology");
            pick1.setItems(list1);
            search();
            counter=0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void switchToProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}