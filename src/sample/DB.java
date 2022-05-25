package sample;

import java.sql.*;

public class DB {
    Connection c;
    String URL= "jdbc:mysql://localhost/tutorial";
    String user="root";
    String password="";

    public  DB(){}

    public void connect(String userid, String pass){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= (Connection) DriverManager.getConnection(URL, user, password);
            System.out.println("Connection Succeeded..........");
            Statement st= c.createStatement();
            ResultSet result =st.executeQuery("SELECT * FROM `user`");
            result.next();
            userid=result.getString(4);
            pass=result.getString(5);
            System.out.println(userid+","+pass);
            c.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed............");
        }
    }
}
