package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoDAO{

    public static Connection connection(){

        Connection conn = null;

        String url = "jdbc:postgresql://localhost:5432/SP";
        String user = "postgres";
        String password = "camileisi";

        try{

            conn = DriverManager.getConnection(url, user, password);

            if(conn != null){

                System.out.println("Conexão bem-sucedida com o PostgreSQL!");

            }else{

                System.out.println("Erro ao conectar ao banco de dados:");

            }

        }catch (SQLException e){

            System.out.println(e);

        }

        return conn;

    }
}
