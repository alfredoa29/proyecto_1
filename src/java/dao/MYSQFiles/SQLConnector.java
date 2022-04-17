package model.SQLFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
    private  static SQLConnector instance;
    private Connection dbConn;
    private String URL = "jdbc:mysql://localhost:3306/proyecto_2";

    private SQLConnector(String user, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConn = DriverManager.getConnection(URL, user, password);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public Connection getConnection() {
        return dbConn;
    }

    public static SQLConnector getInstance(String user, String passworrd) throws SQLException{
        if(instance ==null){
            instance = new SQLConnector(user, passworrd);
        } else if (instance.getConnection().isClosed()){
            instance = new SQLConnector(user, passworrd);

        }
        return instance;
    }

}
