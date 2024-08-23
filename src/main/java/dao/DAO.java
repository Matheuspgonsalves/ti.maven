package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Carro;

import javax.swing.plaf.nimbus.State;

public class DAO {
    public Connection conexao_bd(){
        Connection conn = null;

        String driverName = "org.postgresql.Driver";
        String serverName = "localhost";
        String myDb = "teste";
        int porta = 5432;
        String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + myDb;
        String username = "ti2cc";
        String password = "ti@cc";

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
            if(conn != null){
                System.out.println("Conexão estabelecida");
            } else {
                System.out.println("Conexão não estabelecida");
            }

        }catch (ClassNotFoundException e){
            System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
        } catch (SQLException e){
            System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
        }
        return conn;
    }
}
