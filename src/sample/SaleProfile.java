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
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static sample.AlltheVariables.*;
import static sample.AlltheVariables.n2;

public class SaleProfile implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection c;
    String URL = "jdbc:mysql://localhost/tutorial";
    String userID = "root";
    String passwordID = "";
    int var=0;
    static int counter =0;
    static int cntr=0;
    static int delete;

    @FXML
    private ImageView i1;
    @FXML
    private Label l1;
    @FXML
    private Hyperlink h1;
    @FXML
    private ImageView i2;
    @FXML
    private Label l3;
    @FXML
    private Hyperlink h2;
    @FXML
    private ImageView i3;
    @FXML
    private Label l5;
    @FXML
    private Hyperlink h3;
    @FXML
    private ImageView i4;
    @FXML
    private Label l7;
    @FXML
    private Hyperlink h4;
    @FXML
    private ImageView i5;
    @FXML
    private Label l9;
    @FXML
    private Hyperlink h5;
    @FXML
    private ImageView i6;
    @FXML
    private Label l11;
    @FXML
    private Hyperlink h6;
    @FXML
    private ImageView i7;
    @FXML
    private Label l13;
    @FXML
    private Hyperlink h7;
    @FXML
    private ImageView i8;
    @FXML
    private Label l15;
    @FXML
    private Hyperlink h8;
    @FXML
    private ImageView i9;
    @FXML
    private Label l17;
    @FXML
    private Hyperlink h9;
    @FXML
    private ImageView i10;
    @FXML
    private Label l19;
    @FXML
    private Hyperlink h10;

    @FXML
    private Label uname;

    @FXML
    private ImageView dp;

    @FXML
            private Button buttonB;
    @FXML
            private Button buttonN;

    int n2=0;
    int n3=10;
    

    public void connection() throws ClassNotFoundException, SQLException, IOException {
        userbooklist.removeAll(userbooklist);
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = (Connection) DriverManager.getConnection(URL, userID, passwordID);
        System.out.println("Connection Succeeded..........");
        //--------------------



        userbooklist.removeAll(userbooklist);
        Statement st = c.createStatement();
        String string="SELECT * FROM `store` WHERE `username` LIKE '"+Nameofuser+"'";
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
        String string1="SELECT COUNT(*) AS rowcount FROM `store` WHERE `username` LIKE '"+Nameofuser+"'";
        ResultSet r1 = s.executeQuery(string1);
        r1.next();
        cnt = r1.getInt("rowcount");

        for(int i=0;i<50;i++) {
            Book b = new Book();
            userbooklist.add(b);
        }

        for (int i = 0; i <cnt; i++)
        {

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
            userbooklist.get(i).hplink= "Delete";
            res.next();
        }
        System.out.println(n2+" "+n3);
        for (int i = 0+n2; i <0+n3; i++)
        {
            System.out.println(i);
            Book bk = userbooklist.get(i);

            if (i == n2+0 ) {

                i1.setImage(bk.img);
                l1.setText(bk.bn);
                h1.setText(bk.hplink);


            }
            else if (i ==n2+1 ) {

                i2.setImage(bk.img);
                l3.setText(bk.bn);
                h2.setText(bk.hplink);


            } else if (i ==n2+2 ) {

                i3.setImage(bk.img);
                l5.setText(bk.bn);
                h3.setText(bk.hplink);

            } else if (i ==n2+3 ) {

                i4.setImage(bk.img);
                l7.setText(bk.bn);
                h4.setText(bk.hplink);

            } else if (i ==n2+4 ) {

                i5.setImage(bk.img);
                l9.setText(bk.bn);
                h5.setText(bk.hplink);

            }
            else if (i ==n2+5 ) {

                i6.setImage(bk.img);
                l11.setText(bk.bn);
                h6.setText(bk.hplink);

            } else if (i ==n2+6 ) {

                i7.setImage(bk.img);
                l13.setText(bk.bn);
                h7.setText(bk.hplink);

            } else if (i ==n2+7 ) {

                i8.setImage(bk.img);
                l15.setText(bk.bn);
                h8.setText(bk.hplink);;

            } else if (i ==n2+8 ) {

                i9.setImage(bk.img);
                l17.setText(bk.bn);
                h9.setText(bk.hplink);

            } else if (i ==n2+9 ) {

                i10.setImage(bk.img);
                l19.setText(bk.bn);
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
        System.out.println(n2+ " "+ n3);
        connection();
        /*for (int i = 0+n2; i <0+n3; i++)
        {
            System.out.println(i);
            Book bk = userbooklist.get(i);

            if (i == n2+0 ) {

                i1.setImage(bk.img);
                l1.setText(bk.bn);
                h1.setText(bk.hplink);


            }
            else if (i ==n2+1 ) {

                i2.setImage(bk.img);
                l3.setText(bk.bn);
                h2.setText(bk.hplink);


            } else if (i ==n2+2 ) {

                i3.setImage(bk.img);
                l5.setText(bk.bn);
                h3.setText(bk.hplink);

            } else if (i ==n2+3 ) {

                i4.setImage(bk.img);
                l7.setText(bk.bn);
                h4.setText(bk.hplink);

            } else if (i ==n2+4 ) {

                i5.setImage(bk.img);
                l9.setText(bk.bn);
                h5.setText(bk.hplink);

            }
            else if (i ==n2+5 ) {

                i6.setImage(bk.img);
                l11.setText(bk.bn);
                h6.setText(bk.hplink);

            } else if (i ==n2+6 ) {

                i7.setImage(bk.img);
                l13.setText(bk.bn);
                h7.setText(bk.hplink);

            } else if (i ==n2+7 ) {

                i8.setImage(bk.img);
                l15.setText(bk.bn);
                h8.setText(bk.hplink);;

            } else if (i ==n2+8 ) {

                i9.setImage(bk.img);
                l17.setText(bk.bn);
                h9.setText(bk.hplink);

            } else if (i ==n2+9 ) {

                i10.setImage(bk.img);
                l19.setText(bk.bn);
                h10.setText(bk.hplink);
            }

        }*/
    }
    public void back(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        n2 -=10;
        n3 -=10;
        var-=10;
        System.out.println(n2);
        System.out.println(n3);
        connection();
    }
    @FXML
    void page1(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(0+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page2(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(1+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page3(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(2+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page4(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(3+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page5(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(4+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page6(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(5+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page7(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(6+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page8(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();

        delete=userbooklist.get(7+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }

    @FXML
    void page9(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();
        uname.setText(Nameofuser);
        delete=userbooklist.get(8+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }
    @FXML
    void page10(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        connection();
        delete=userbooklist.get(9+var).id;
        System.out.println(delete);
        String sql = "DELETE FROM `store` WHERE `id` = ?";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setInt(1, delete);
        pstmt.executeUpdate();

        connection();

    }


    public void switchToLogIn(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBookProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BookProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Searchpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToEditProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Edit.fxml"));
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
    public void switchToBookUploadForm(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BookUploadForm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            uname.setText(Nameofuser);
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
}
