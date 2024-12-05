package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDAO{

    public static Connection connection(){

        Connection conn = null;

        String url = "jdbc:postgresql://localhost:5432/SP";
        String user = "postgres";
        String password = "admin";

        try{

            conn = DriverManager.getConnection(url, user, password);

        }catch (SQLException e){

            System.out.println(e);

        }

        return conn;

    }
}
