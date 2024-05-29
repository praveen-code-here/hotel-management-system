package edu.ijse.lovers_leap.db;
import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.jar.JarOutputStream;
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    private DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/lovers_leap","root","1234");
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }

    }

    public static  DBConnection getInstance(){
        if(dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }

    

}
