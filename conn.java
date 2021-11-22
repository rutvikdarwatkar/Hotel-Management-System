package hotel.management.system;

import java.sql.*;
public class conn {
    Connection c;
    Statement s;


    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///projecthms","root","8308398911");
            s=c.createStatement();      //conect database
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}
